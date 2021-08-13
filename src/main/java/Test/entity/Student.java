package Test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * @Author: GodChin
 * @Date: 2021/8/13 15:05
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */

@Data
@Accessors(chain = true)
public class Student {
    private String name;
    private Integer age;
    private String address;
}
