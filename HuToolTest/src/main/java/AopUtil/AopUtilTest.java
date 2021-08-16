package AopUtil;

import cn.hutool.aop.ProxyUtil;
import cn.hutool.aop.aspects.TimeIntervalAspect;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 13:47
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 切面工具类
 *
 * <dependency>
 *     <groupId>cglib</groupId>
 *     <artifactId>cglib</artifactId>
 *     <version>3.2.7</version>
 * </dependency>
 */
public class AopUtilTest {
    public static void main(String[] args) {
        Dog dog = ProxyUtil.proxy(new Dog(), TimeIntervalAspect.class);
        String result = dog.eat();
    }
}
