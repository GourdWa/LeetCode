package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-19  8:53
 * @description 最大子序和
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp < 0) {
                temp = 0;
            }
            temp += nums[i];
            max = Math.max(temp, max);
        }
        return max;
    }
}
