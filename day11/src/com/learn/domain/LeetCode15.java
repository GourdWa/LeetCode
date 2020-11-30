package com.learn.domain;

import java.util.*;

/**
 * @author ZixiangHu
 * @create 2020-05-18  9:48
 * @description
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3 || nums == null)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
