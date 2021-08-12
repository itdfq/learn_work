package com.itdfq.send.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author GocChin
 * @Date 2021/8/3 11:19
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private Integer age;
    private String time;
}
