package com.itdfq.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: QianMo
 * @Date: 2021/9/16 17:35
 * @Description:
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class Demo2Plan1 {
    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ;i<nums.length;i++){
            int a = target-nums[i];
            if(map.containsKey(a)){
                if(map.get(a)!=i){
                    list.add(i);
                    list.add(map.get(a));
                    break;
                }
            }
        }
        System.out.println(list);
    }
}
