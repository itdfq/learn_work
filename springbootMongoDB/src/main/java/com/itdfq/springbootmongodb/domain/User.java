package com.itdfq.springbootmongodb.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @Author GocChin
 * @Date 2021/8/5 15:08
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
@Data
public class User {
    private String id;
    private String name;
    private Integer age;
    private String gender;

}
