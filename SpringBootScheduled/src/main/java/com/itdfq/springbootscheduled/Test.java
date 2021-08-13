package com.itdfq.springbootscheduled;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import java.util.concurrent.TimeUnit;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 9:57
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
@Component
public class Test {

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }
    @Scheduled(cron = "0/5 * * * * ?")
    public void test1(){
        String name = Thread.currentThread().getName();
        System.out.println("当前时间:"+ LocalDateTime.now()+"  任务1对应的线程名: "+name);
        try {
            TimeUnit.SECONDS.sleep(1); //睡眠一秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Scheduled(cron = "0/5 * * * * ?")
    public void test2(){
        String name = Thread.currentThread().getName();
        System.out.println("当前时间:"+ LocalDateTime.now()+"  任务2对应的线程名: "+name);
        try {
            TimeUnit.SECONDS.sleep(1); //睡眠一秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
