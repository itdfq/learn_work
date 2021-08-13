package com.itdfq.springlistener.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: GodChin
 * @Date: 2021/8/12 9:56
 * @Description:
 */
@Component
public class TestEventHandler implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(TestEvent testEvent) {
        System.out.println("处理器执行了");
        System.out.println(testEvent);
        System.out.println(testEvent.getName());
        System.out.println(testEvent.getSource());
    }
}
