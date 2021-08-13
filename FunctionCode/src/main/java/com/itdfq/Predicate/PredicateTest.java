package com.itdfq.Predicate;

import org.springframework.util.Assert;

import java.util.function.Predicate;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 17:01
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:  Predicate为函数式接口，predicate的中文意思是“断定”，即判断的意思，判断某个东西是否满足某种条件；
 *           因此它包含test方法，根据输入值来做逻辑判断，其结果为True或者False。
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> p = o -> o.equals("test");
        Predicate<String> g = o -> o.startsWith("t");
        /**
         * negate: 用于对原来的Predicate做取反处理；
         * 如当调用p.test("test")为True时，调用p.negate().test("test")就会是False；
         */
        Assert.isTrue(p.negate().test("test"),"当前不能为真");

    }
}
