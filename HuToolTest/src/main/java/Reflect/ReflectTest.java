package Reflect;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.ReflectUtil;

import java.lang.reflect.Method;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 17:44
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description: 使用ReflectUtil工具 反射
 */
public class ReflectTest {
    public static void main(String[] args) {
        Method[] methods = ReflectUtil.getMethods(Demo.class);
        System.out.println(methods[0]);
        //构造对象
        Demo demo = ReflectUtil.newInstance(Demo.class);
        ReflectUtil.invoke(demo,"getName","测试");
        String s = DesensitizedUtil.idCardNum("51343620000320711X", 3, 2);
        System.out.println(s);


    }
}