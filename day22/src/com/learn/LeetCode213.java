package com.learn;

/**
 * @author ZixiangHu
 * @create 2020-05-29  11:55
 * @description 213. 打家劫舍 II
 */
public class LeetCode213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        //dp1存储始终不偷最后一家能得到的金额
        int[] dp1 = new int[nums.length - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        //dp2存储始终不偷第一家能得到的金额
        int[] dp2 = new int[nums.length - 1];
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[2], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (i >= 3)
                dp2[i - 1] = Math.max(dp2[i - 2], nums[i] + dp2[i - 3]);
            if (i < nums.length - 1)
                dp1[i] = Math.max(dp1[i - 1], nums[i] + dp1[i - 2]);
        }
        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}
