package com.itdfq.mybatisgeneratortest;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itdfq.mybatisgeneratortest.mapper")
public class MybatisGeneratorTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisGeneratorTestApplication.class, args);
    }

}
