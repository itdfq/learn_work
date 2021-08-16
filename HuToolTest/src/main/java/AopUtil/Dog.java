package AopUtil;

import cn.hutool.core.lang.Console;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 13:51
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Dog {
    public String eat() {
        Console.log("狗吃肉");
        return "狗吃肉";
    }
}
