import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 17:29
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int[] arrayOK = list.stream().mapToInt(i -> (int) i).toArray();

        System.out.println(arrayOK[0]);

    }
}
