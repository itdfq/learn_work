package com.itdfq;

import com.itdfq.annotation.GetName;

/**
 * @Author: QianMo
 * @Date: 2021/9/15 9:17
 * @Description: 自定义注解
 */
@GetName(name = "Demo1类",value = "类属性注解")
public class Demo1 {
    @GetName(name = "name字段",value = "属性注解")
    private String name;
    @GetName(name = "test()方法注解",value = "方法注解")
    public void test(){
        System.out.println("123");
    }
    public void hello(){
        System.out.println("hello world");
    }
}
