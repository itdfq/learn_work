package com.itdfq.zookeeper;

import com.itdfq.zookeeper.config.ZkApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Properties;

@SpringBootTest
class ZookeeperApplicationTests {

    @Autowired
    private ZkApi zkApi;


    @Autowired
    private Properties properties;

    @Test
    void contextLoads() {

    }

    @Test
    public void get() {
        String test = zkApi.getProperties("project.name");
        System.out.println(test);
    }

    @Test
    public void set() throws Exception {
        zkApi.setProperties("project.name", "spring.application.name=Zookeeper123更新数据");
    }


}
