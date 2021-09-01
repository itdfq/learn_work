package ListDemo;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: QianMo
 * @Date: 2021/9/1 14:41
 * @Description:  apache 使用CollectionUtils实现交 并 差
 */
public class ListTest2 {
    public static void main(String[] args) {

        String[] arrayA = new String[] { "1", "2", "3", "4"};
        String[] arrayB = new String[] { "3", "4", "5", "6" };
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);

        //1、并集 union
        System.out.println(CollectionUtils.union(listA, listB));
        //输出: [1, 2, 3, 4, 5, 6]

        //2、交集 intersection
        System.out.println(CollectionUtils.intersection(listA, listB));
        //输出:[3, 4]

        //3、交集的补集（析取）disjunction
        System.out.println(CollectionUtils.disjunction(listA, listB));
        //输出:[1, 2, 5, 6]

        //4、差集（扣除）
        System.out.println(CollectionUtils.subtract(listA, listB));
        //输出:[1, 2]
    }

}
