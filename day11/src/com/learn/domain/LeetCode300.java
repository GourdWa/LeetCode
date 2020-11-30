package com.learn.domain;

import java.util.Arrays;

/**
 * @author ZixiangHu
 * @create 2020-05-18  12:13
 * @description 最长上升子序列
 */
public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        int[] maxLen = new int[nums.length];
        for(int i = 0;i < nums.length;i ++)
            maxLen[i] = 1;

        for(int i = 1;i < nums.length;i ++)
        {
            for(int j = 0;j < i;j ++)
            {
                if(nums[i] > nums[j])
                {
                    maxLen[i] = Math.max(maxLen[i],maxLen[j] + 1);
                }
            }
        }
        Arrays.sort(maxLen);
        return maxLen[maxLen.length - 1];
    }
}
