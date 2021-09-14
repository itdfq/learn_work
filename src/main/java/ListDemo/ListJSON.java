package ListDemo;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: QianMo
 * @Date: 2021/9/2 21:16
 * @Description:
 */
public class ListJSON {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1","2","3");
        System.out.println(JSON.toJSONString(list));
        System.out.println(list);
    }
}
