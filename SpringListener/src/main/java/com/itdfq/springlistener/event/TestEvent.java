package com.itdfq.springlistener.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: GodChin
 * @Date: 2021/8/12 9:55
 * @Blog: http://itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class TestEvent extends ApplicationEvent {
    private String name;

    public TestEvent(Integer source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
