package com.itdfq.kafka.controller;

import com.itdfq.kafka.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: QianMo
 * @Date: 2021/10/29 14:28
 * @Description:
 */
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/send")
    public void sendMsg() {
        kafkaProducer.send("this is a test message!");
        log.info("发送成功");
    }

    @GetMapping("/send2")
    public void send2(){
        kafkaProducer.sendByKey("key","使用key发送");
        log.info("发送成功");
    }

}
