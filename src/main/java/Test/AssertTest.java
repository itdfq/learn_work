package Test;

import org.springframework.util.Assert;

/**
 * @Author: GodChin
 * @Date: 2021/8/12 16:40
 * @Blog: http://itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class AssertTest {
    public static void main(String[] args) {
        Integer age =null;
        Assert.notNull(age,"age不能为空");
    }
}
