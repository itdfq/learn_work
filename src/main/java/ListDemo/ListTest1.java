package ListDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: QianMo
 * @Date: 2021/9/1 14:40
 * @Description: List原生集合  交 并 差
 */
public class ListTest1 {
    public static void main(String[] args) {

        String[] arrayA = new String[] { "1", "2", "3", "4"};
        String[] arrayB = new String[] { "3", "4", "5", "6" };
        List<String> listA = Arrays.asList(arrayA);
        List<String> listB = Arrays.asList(arrayB);

        //1、交集
        List<String> jiaoList = new ArrayList<>(listA);
        jiaoList.retainAll(listB);
        System.out.println(jiaoList);
        //输出:[3, 4]

        //2、差集
        List<String>  chaList = new ArrayList<>(listA);
        chaList.removeAll(listB);
        System.out.println(chaList);
        //输出:[1, 2]

        //3、并集 (先做差集再做添加所有）
        List<String>  bingList = new ArrayList<>(listA);
        bingList.removeAll(listB); // bingList为 [1, 2]
        bingList.addAll(listB);  //添加[3,4,5,6]
        System.out.println(bingList);
        //输出:[1, 2, 3, 4, 5, 6]
    }

}
