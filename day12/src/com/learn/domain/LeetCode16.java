package com.learn.domain;

import java.util.Arrays;

/**
 * @author ZixiangHu
 * @create 2020-05-19  10:46
 * @description
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minAbs = Math.abs(target - nums[0] - nums[1] - nums[2]);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 1 && nums[i - 1] == nums[i])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                int abs = target - nums[i] - nums[left] - nums[right];
                if (abs == 0)
                    return target;
                else if (Math.abs(abs) < minAbs) {
                    minAbs = Math.abs(abs);
                    ans = sum;
                }
                if (abs > 0)
                    left++;
                else right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode16().threeSumClosest(new int[]{1, 2, 5, 10, 11}, 12);
    }
}
