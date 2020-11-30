package com.learn.domain;

import java.rmi.UnexpectedException;
import java.util.Arrays;

/**
 * @author ZixiangHu
 * @create 2020-05-26  10:28
 * @description
 */
public class LeetCode287 {
    //暴力
/*    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]==nums[j])
                    return nums[i];
            }
        }
        return -1;
    }*/
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int right = len - 1;
        int left = 1;
        int mid;
        while (right > left) {
            int cnt = 0;
            mid = left + (right - left) / 2;
            for (int num : nums) {
                if (num <= mid)
                    cnt++;
            }
            if (cnt > mid) {
                right = mid;
            } else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        new LeetCode287().findDuplicate(new int[]{1, 2, 4, 3, 4, 5, 6, 7});
    }
}
