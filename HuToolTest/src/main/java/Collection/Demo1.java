package Collection;

import cn.hutool.core.collection.CollUtil;

import java.util.List;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 17:55
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        String[] col= new String[]{"a","b","c","d","e"};
        List<String> colList = CollUtil.newArrayList(col);
        //join
        String str = CollUtil.join(colList, "#"); //str -> a#b#c#d#e

    }
}
