package com.itdfq.zookeeper.config;


import com.alibaba.fastjson.JSON;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

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
public class ZkConfig {

    private Properties properties = new Properties();
    /**
     * 可以理解curatorFramework为客户端，基本操作都由它完成
     */
    private CuratorFramework curatorFramework = null;
    private TreeCache treeCache = null;

    @Value("${zookeeper.url}")
    private String zkUrl;
    /**
     * 根节点
     */
    @Value("${zookeeper.projectName}")
    private String projectName;
    /**
     * 分隔符
     */
    private final String SEPARATOR = "/";
    private static final int BASE_SLEEP_TIME_MS = 1000;
    /**
     * 最大重试次数
     */
    private static final int MAX_RETRIES = 3;

    //初始化
    private void init() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIME_MS, MAX_RETRIES);
        curatorFramework = CuratorFrameworkFactory.newClient(zkUrl, retryPolicy);
        treeCache = new TreeCache(curatorFramework, projectName);
    }

    /**
     * 设置属性
     *
     * @param key
     * @param value
     * @throws Exception
     */
    public void setProperties(String key, String value) throws Exception {
        String propertiesKey = projectName + SEPARATOR + key;
        Stat stat = curatorFramework.checkExists().forPath(propertiesKey);
        if (stat == null) {
            curatorFramework.create().forPath(propertiesKey);
        }
        curatorFramework.setData().forPath(propertiesKey, value.getBytes());
    }

    /**
     * 获取属性
     *
     * @param key
     * @return
     */
    public String getProperties(String key) {
        return properties.getProperty(key);
    }

    @PostConstruct
    public void loadProperties() {
        try {
            init();
            curatorFramework.start();
            treeCache.start();

            // 从zk中获取配置放入本地配置中
            Stat stat = curatorFramework.checkExists().forPath(projectName);
            if (stat == null) {
                curatorFramework.create().forPath(projectName);
            }
            List<String> configList = curatorFramework.getChildren().forPath(projectName);
            if (configList.size() > 0) {
                for (String s : configList) {
                    byte[] value = curatorFramework.getData().forPath(projectName + SEPARATOR + s);
                    properties.setProperty(projectName, new String(value));
                }
            }
            // 监听属性值变更
            treeCache.getListenable().addListener(new TreeCacheListener() {
                @Override
                public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                    if (Objects.equals(treeCacheEvent.getType(), TreeCacheEvent.Type.NODE_ADDED) ||
                            Objects.equals(treeCacheEvent.getType(), TreeCacheEvent.Type.NODE_UPDATED)) {
                        String updateKey = treeCacheEvent.getData().getPath().replace(projectName + SEPARATOR, "");
                        properties.setProperty(updateKey, new String(treeCacheEvent.getData().getData()));
                        log.info("数据更新：更新类型【{}】，更新的key:【{}】,更新value:【{}】", treeCacheEvent.getType(), projectName + SEPARATOR + updateKey, new String(treeCacheEvent.getData().getData()));
                    }
                }
            });

        } catch (Exception e) {
            log.error("zk配置初始化异常", e);
        }
    }


    /**
     * 分布式锁 对象
     * @param path
     * @return
     */
    public  InterProcessMutex getLock(String path){
        InterProcessMutex lock=null;
        try {
            lock=new InterProcessMutex(curatorFramework, projectName+SEPARATOR+path);
            return  lock;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
