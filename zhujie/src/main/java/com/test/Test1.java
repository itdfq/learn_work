package com.test;

/**
 * @Author Qianmo
 * @Date 2021/8/11 9:21
 * @Description:  可变长度参数
 */
public class Test1 {
    public static void main(String[] args) {
        Integer max = max(1, 2, 3, 4, 5, 6, 7);
        System.out.println(max);
        System.out.println(max(1));
        System.out.println(max(1, 2));
        System.out.println(max(4, 6, 1, 3));

    }
    public static Integer max(Integer ... nums){
        int max = nums[0];
        for (int i=0;i<nums.length;i++){
            if (max<nums[i]){
                max=nums[i];
            }
        }
        return max;
    }
}
