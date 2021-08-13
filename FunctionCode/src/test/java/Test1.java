import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 17:00
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        // 将Stream转换成容器或Map
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(map);
    }
}
