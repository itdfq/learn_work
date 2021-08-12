package com.itdfq.send.controller;

import com.alibaba.fastjson.JSON;
import com.itdfq.send.domain.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.logging.SimpleFormatter;

/**
 * @Author GocChin
 * @Date 2021/8/3 10:54
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
@RestController
public class TestController {
    @Autowired
    private RabbitTemplate rabbitTemplate;



    @GetMapping("/test")
    public String direct(@RequestParam(required = true) String Key){
        Student student = new Student();
        student.setName("小明");
        student.setAge(13);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        student.setTime(sf.format(new Date()));
        String sendMsg = "key("+Key+"),exchange(direct)-"+System.currentTimeMillis(); //currentTimeMillis时间戳
        System.out.println("DirectSender:"+sendMsg);
        System.out.println("发送的对象："+JSON.toJSONString(student));
        this.rabbitTemplate.convertAndSend("DirectExchange",Key, JSON.toJSONString(student));
        return "发送direct消息成功";

    }
}
