package com.learn.domain;

import java.util.Arrays;

/**
 * @author ZixiangHu
 * @create 2020-06-02  16:51
 * @description 31. 下一个排列
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        int i, j, t;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        j = nums.length - 1;
        if (i != -1) {
            while (nums[j] <= nums[i])
                j--;
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            Arrays.sort(nums, i + 1, nums.length);
        } else {
            for (i = 0; i < nums.length / 2; i++) {
                t = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 4, 1};
        new LeetCode31().nextPermutation(new int[]{1, 5,1});
        Arrays.sort(arr, 1, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
