package com.itdfq.array;

/**
 * @Author: QianMo
 * @Date: 2021/9/16 13:27
 * @Description:
 */
public class Demo1Plan2 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4, 7, 4, -3}; //16
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            //计算前i个的和
            sum = sum+nums[i];
            //如果前n个和还不如当前元素的大
            if (sum<=nums[i]){
                sum=nums[i];
            }
            //获取最大值
            if (max<=sum){
                max = sum;
            }
        }
        System.out.println(max);
    }



}
