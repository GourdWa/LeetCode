package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-06  18:01
 * @description LeetCode 53
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum < 0 ? 0 : sum;
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
