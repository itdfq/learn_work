package ListDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @Author: QianMo
 * @Date: 2021/9/1 14:49
 * @Description: Stream流实现交并差
 */
public class ListTest3 {
    public static void main(String[] args) {

        String[] arrayA = new String[]{"1", "2", "3", "4"};
        String[] arrayB = new String[]{"3", "4", "5", "6"};
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);

        // 交集
        List<String> intersection = listA.stream().filter(item -> listB.contains(item)).collect(toList());
        System.out.println(intersection);
        //输出:[3, 4]

        // 差集 (list1 - list2)
        List<String> reduceList = listA.stream().filter(item -> !listB.contains(item)).collect(toList());
        System.out.println(reduceList);
        //输出:[1, 2]

        // 并集 （新建集合:1、是因为不影响原始集合。2、Arrays.asList不能add和remove操作。
        List<String> listAll = listA.parallelStream().collect(toList());
        List<String> listAll2 = listB.parallelStream().collect(toList());
        listAll.addAll(listAll2);
        System.out.println(listAll);
        //输出:[1, 2, 3, 4, 3, 4, 5, 6]

        // 去重并集
        List<String> list = new ArrayList<>(listA);
        list.addAll(listB);
        List<String> listAllDistinct = list.stream().distinct().collect(toList());
        System.out.println(listAllDistinct);
        //输出:[1, 2, 3, 4, 5, 6]
    }

}
