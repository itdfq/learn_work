package com.itdfq.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: QianMo
 * @Date: 2021/9/16 10:45
 * @Description: 数组算法
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4,7,4,-3};
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            //如果前几个相加还没有当前的值大，就放弃，取当前值
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        System.out.println(maxAns);
    }
}
