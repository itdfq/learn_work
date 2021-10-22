package com.itdfq.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: QianMo
 * @Date: 2021/9/16 18:27
 * @Description:
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        int a = 0;
        for (int i = n ; i < m+n; i++) {
            nums1[i] = nums2[a];
            a++;
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
