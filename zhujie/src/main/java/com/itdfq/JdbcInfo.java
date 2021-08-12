package com.itdfq;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author GocChin
 * @Date 2021/8/6 15:49
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JdbcInfo {
    String driverClassName();

    String url();

    String username();

    String password();
}
