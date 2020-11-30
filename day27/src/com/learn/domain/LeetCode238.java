package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-06-04  11:10
 * @description 238. 除自身以外数组的乘积
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        //lArr[i]代表i左边的数字的乘积
        //rArr[i]代表i右边的数字的乘积
        //因此output[i]=左边乘积*右边乘积
        int rArr[] = new int[nums.length];
        int lArr[] = new int[nums.length];
        lArr[0] = 1;
        rArr[nums.length - 1] = 1;
        int[] output = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            lArr[i] = lArr[i - 1] * nums[i - 1];
            rArr[nums.length - i - 1] = rArr[nums.length - i] * nums[nums.length - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            output[i] = lArr[i] * rArr[nums.length - i - 1];
        }
        return output;
    }
}
