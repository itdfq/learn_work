package com.itdfq;

/**
 * @Author: GodChin
 * @Date: 2021/8/11 9:58
 * @Description:
 */
public class Student {

    @JdbcInfo(driverClassName = "123",url = "345",username = "12424",password = "fdsdfsdf")
    public void study(int times){
        for(int i = 0; i < times; i++){
            System.out.println("Good Good Study, Day Day Up!");
        }
    }

}
