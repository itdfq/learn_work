package com.itdfq.zookeeper;

import com.itdfq.zookeeper.config.ZkConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZookeeperApplicationTests {

    @Autowired
    private ZkConfig zkConfig;

    @Test
    void contextLoads() {
    }

    @Test
    public void get() {
        String test = zkConfig.getProperties("project.name");
        System.out.println(test);
    }

    @Test
    public void set() throws Exception {
        zkConfig.setProperties("project.name", "spring.application.name=Zookeeper123更新数据");
    }


}
