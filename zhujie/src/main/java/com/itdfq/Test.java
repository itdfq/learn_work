package com.itdfq;



import java.lang.annotation.Annotation;

import java.lang.reflect.Method;

/**
 * @Author GocChin
 * @Date 2021/8/6 15:49
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        try {
            //获取类
            Class c = Class.forName("com.itdfq.Student");
            //找到方法
            Method stuMethod = c.getMethod("study",int.class);
            //判断方法有没有添加注解
            if (stuMethod.isAnnotationPresent(JdbcInfo.class)){
                System.out.println(stuMethod.getName()+"配置了注解");
                //获取方法上的注解参数
                Annotation[] annotations = stuMethod.getAnnotations();
                System.out.println(annotations[0]);
                JdbcInfo annotation = stuMethod.getAnnotation(JdbcInfo.class);
                System.out.println(annotation);
            }
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
