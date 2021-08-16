package Jiami;

import cn.hutool.core.codec.Base62;

/**
 * @Author: GodChin
 * @Date: 2021/8/16 9:07
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: Base64加密解密
 */
public class Demo1 {
    public static void main(String[] args) {
        String a = "伦家是一个非常长的字符串66";
// 17vKU8W4JMG8dQF8lk9VNnkdMOeWn4rJMva6F0XsLrrT53iKBnqo
        String encode = Base62.encode(a);
        System.out.println("加密之后"+encode);
// 还原为a
        String decodeStr = Base62.decodeStr(encode);
        System.out.println("解密之后"+decodeStr);
    }
}
