package Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author GocChin
 * @Date 2021/7/27 15:48
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("key",123);
        map.put("key",345);
        System.out.println(map.get("key"));
    }
}
