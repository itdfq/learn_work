package com.itdfq.zookeeper.config;


import com.itdfq.zookeeper.constant.ZkConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.framework.recipes.cache.TreeCacheEvent;
import org.apache.curator.framework.recipes.cache.TreeCacheListener;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.Properties;


/**
 * @Author: QianMo
 * @Date: 2021/10/25 10:22
 * @Description:
 */
@Configuration
@Slf4j
@Component
public class ZkApi {
    @Autowired
    private ZkProperties zkProperties;

    /**
     * 配置（单例）
     *
     * @return
     */
    @Bean
    public Properties getProperties() {
        return new Properties();
    }

    /**
     * Zookeeper 框架式客户端
     *
     * @return CuratorFramework
     */
    @Bean
    public CuratorFramework getCuratorFramework() {
        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(zkProperties.getBaseSleepTimeMs(), zkProperties.getMaxRetries());
        return CuratorFrameworkFactory.newClient(zkProperties.getUrl(), retryPolicy);
    }

    /**
     * 监视 ZK
     *
     * @return TreeCache
     */
    @Bean
    public TreeCache getTreeCache() {
        return new TreeCache(curatorFramework, zkProperties.getProjectName());
    }

    @Autowired
    private CuratorFramework curatorFramework;
    @Autowired
    private TreeCache treeCache;

    private Properties properties = new Properties();

    @PostConstruct
    public void loadProperties() {
        try {
            curatorFramework.start();
            treeCache.start();
            // 从zk中获取配置放入本地配置中
            Stat stat = curatorFramework.checkExists().forPath(zkProperties.getProjectName());
            if (stat == null) {
                curatorFramework.create().forPath(zkProperties.getProjectName());
            }
            List<String> configList = curatorFramework.getChildren().forPath(zkProperties.getProjectName());
            if (configList.size() > 0) {
                for (String s : configList) {
                    byte[] value = curatorFramework.getData().forPath(zkProperties.getProjectName() + ZkConstant.SEPARATOR + s);
                    properties.setProperty(zkProperties.getProjectName(), new String(value));
                }
            }
            // 监听属性值变更
            treeCache.getListenable().addListener(new TreeCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                    if (Objects.equals(treeCacheEvent.getType(), TreeCacheEvent.Type.NODE_ADDED) ||
                            Objects.equals(treeCacheEvent.getType(), TreeCacheEvent.Type.NODE_UPDATED)) {
                        String updateKey = treeCacheEvent.getData().getPath().replace(zkProperties.getProjectName() + ZkConstant.SEPARATOR, "");
                        properties.setProperty(updateKey, new String(treeCacheEvent.getData().getData()));
                        log.info("数据更新：更新类型【{}】，更新的key:【{}】,更新value:【{}】", treeCacheEvent.getType(), zkProperties.getProjectName() + ZkConstant.SEPARATOR + updateKey, new String(treeCacheEvent.getData().getData()));
                    }
                }
            });

        } catch (Exception e) {
            log.error("zk配置初始化异常", e);
        }
    }



    /**
     * 获取同步配置属性
     * zk的value保存在本地缓存
     *
     * @param key
     * @return
     */
    public String getProperties(String key) {
        return properties.getProperty(key);
    }

    /**
     * 获取zk的节点value
     *
     * @return
     */
    public String getZkValue(String key) {
        try {
            byte[] bytes = curatorFramework.getData().forPath(zkProperties.getProjectName() + ZkConstant.SEPARATOR + key);
            return new String(bytes);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 设置zk的key value
     *  <p>
     * 如果项目启动，会同步更新本地配置缓存
     * @param key
     * @param value
     * @return
     */
    public Boolean setZkValue(String key, String value) {
        try {
            String propertiesKey = zkProperties.getProjectName() + ZkConstant.SEPARATOR + key;
            Stat stat = curatorFramework.checkExists().forPath(propertiesKey);
            if (stat == null) {
                curatorFramework.create().forPath(propertiesKey);
            }
            curatorFramework.setData().forPath(propertiesKey, value.getBytes());
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }


    /**
     * 分布式锁 对象
     *
     * @param path
     * @return
     */
    public InterProcessMutex getLock(String path) {
        InterProcessMutex lock = null;
        try {
            lock = new InterProcessMutex(curatorFramework, zkProperties.getProjectName() + ZkConstant.SEPARATOR + path);
            return lock;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
