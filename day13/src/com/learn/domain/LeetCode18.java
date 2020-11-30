package com.learn.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZixiangHu
 * @create 2020-05-20  11:31
 * @description
 */
public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int subVal = target - nums[i];
            //下面实质就是三数求和加了一点小修改
            for (int j = i + 1; j < nums.length; j++) {
                //去重复，且排除 0 0 0 0，target为0的情况
                if (j != i + 1 && j > 0 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[j] + nums[left] + nums[right];
                    if (sum == subVal) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (subVal > sum)
                        left++;
                    else
                        right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode18().fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
    }
}
