package com.learn;

/**
 * @author ZixiangHu
 * @create 2020-05-29  12:59
 * @description 27. 移除元素
 */
public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int left;
        if (nums[0] != val)
            left = 1;
        else left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == val) {
                if (nums[right] == val) {
                    right++;
                } else {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right++;
                }
            } else {
                left++;
                right++;
            }
        }
        return left+1;
    }
}
