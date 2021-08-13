package com.itdfq.mybatisgeneratortest;

import com.alibaba.fastjson.JSON;
import com.itdfq.mybatisgeneratortest.entity.User;
import com.itdfq.mybatisgeneratortest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisGeneratorTestApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void test1(){
        Map<String, String> map = new HashMap<String, String>() {{
            put("a", "haha");
            put("b", "hahaha");
            put("d", "hahe");
            put("c", "haheeee");
        }};

        map.forEach((k, v) -> {
            System.out.print("key=" + k);
            System.out.print("\t");
            System.out.println("value=" + v);
        });
    }



    @Test
    void contextLoads() {
        List<User> all = userService.findAll();
        System.out.println(all);
        System.out.println(JSON.toJSONString(all));
    }
}
