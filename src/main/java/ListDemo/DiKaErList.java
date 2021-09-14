package ListDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: QianMo
 * @Date: 2021/9/10 15:57
 * @Description: 笛卡尔积
 */
public class DiKaErList {
    public static void main(String[] args) {
        List<List<String>> wl = new ArrayList<List<String>>();
        List<String> colorList = Arrays.asList("A", "B", "C");
        wl.add(colorList);
        List<String> sizeList = Arrays.asList("1", "2");
        wl.add(sizeList);
        List<String> placeList = Arrays.asList("#", "$");
        wl.add(placeList);

        List<String> descartesList = cartesianProduct(wl);
        descartesList.forEach(System.out::println);
    }

    public static List<String> cartesianProduct(List<List<String>> wordLists) {

        List<String> cp = wordLists.get(0);
        for (int i = 1; i < wordLists.size(); i++) {
            List<String> secondList = wordLists.get(i);
            List<String> combinedList = cp.stream().flatMap(s1 -> secondList.stream().map(s2 -> s1 + s2))
                    .collect(Collectors.toList());
            cp = combinedList;

        }
        return cp;
    }


}
