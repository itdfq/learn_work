package com.itdfq.Consumer;

import java.util.function.Consumer;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 16:02
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 *      Consumer是一个函数式编程接口； 顾名思义，Consumer的意思就是消费，即针对某个东西我们来使用它，因此它包含有一个有输入而无输出的accept接口方法；
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer c = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };
        c.accept("1242342");

        System.out.println("函数式编程");

        Consumer c1 = (o) -> {
            System.out.println(o);
        };
        c1.accept("函数式编程测试");

        Consumer c2 = System.out::println;
        c2.accept("进行简化");
        Consumer f = System.out::println;
        c2.andThen(f).andThen(f).andThen(f).accept(c2);



    }


}
