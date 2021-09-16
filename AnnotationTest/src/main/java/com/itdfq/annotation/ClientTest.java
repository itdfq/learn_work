package com.itdfq.annotation;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: QianMo
 * @Date: 2021/9/16 9:39
 * @Description:  通过反射获取注解信息
 */
public class ClientTest {
    public static void main(String[] args) throws Exception {
        Class aClass = Class.forName("com.itdfq.Demo1");
        //获取注解类信息
        System.out.println("------------获取注解类信息-----------");
        GetName annotation = (GetName) aClass.getAnnotation(GetName.class);
        System.out.println(annotation.name());
        System.out.println("------------获取方法注解-----------");
        //获取方法注解   使用isAnnotationPresent判断方法上是否使用了注解
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (int i = 0 ; i<declaredMethods.length;i++){
            if (declaredMethods[i].isAnnotationPresent(GetName.class)){
                GetName getName = declaredMethods[i].getAnnotation(GetName.class);
                System.out.println(JSON.toJSONString(getName));
            }
        }
        System.out.println("------------获取指定方法注解信息-----------");
        //获取指定方法注解信息
        Method test = aClass.getDeclaredMethod("test");
        GetName annotation1 = test.getAnnotation(GetName.class);
        System.out.println(JSON.toJSONString(annotation1));
        //获取指定属性字段信息
        System.out.println("------------获取指定属性字段信息-----------");
        Field name = aClass.getDeclaredField("name");
        GetName annotation2 = name.getAnnotation(GetName.class);
        System.out.println(JSON.toJSONString(annotation2));
        System.out.println("------------获取所有字段信息-----------");
        Field[] declaredFields = aClass.getDeclaredFields();

    }
}
