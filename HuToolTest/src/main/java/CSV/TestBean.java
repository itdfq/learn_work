package CSV;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @Author: QianMo
 * @Date: 2021/9/14 11:30
 * @Description:
 */
@Data
public class TestBean {
    // 如果csv中标题与字段不对应，可以使用alias注解设置别名
    @Alias("姓名")
    private String name;
    private String age;
    private String address;
}
