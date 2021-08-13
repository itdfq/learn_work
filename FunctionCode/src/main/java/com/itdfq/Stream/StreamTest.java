package com.itdfq.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: GodChin
 * @Date: 2021/8/13 17:09
 * @Blog: itdfq.com
 * @QQ: 909256107
 * @Description:
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Stream listStream = list.stream();                   //获取串行的Stream对象
        Stream parallelListStream = list.parallelStream();   //获取并行的Stream对象
        System.out.println(listStream.collect(Collectors.toList()));
        System.out.println(parallelListStream.collect(Collectors.toList()));
        Stream s1 = Stream.of("A","B","C","D");

    }
}
