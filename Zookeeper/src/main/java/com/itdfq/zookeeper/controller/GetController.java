package com.itdfq.zookeeper.controller;

import com.itdfq.zookeeper.config.ZkApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: QianMo
 * @Date: 2021/10/25 11:20
 * @Description:
 */
@RestController
@Slf4j
public class GetController {
    @Autowired
    private ZkApi zkApi;

    @RequestMapping("/get/{key}")
    public String get(@PathVariable("key") String key) {
        log.info("请求参数：{}", key);
        return "结果：" + zkApi.getProperties(key);
    }


}
