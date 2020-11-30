package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-28  19:21
 * @description 删除排序数组中的重复项
 */
public class LeetCode26 {
/*    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = left + 1;
        while (right < nums.length) {
            if (nums[right] == nums[left])
                right++;
            else {
                int pos = left + 1;
                while (pos < right) {
                    nums[pos] = nums[right];
                    pos += 1;
                }
                left += 1;
                right = left + 1;
            }
        }
        return left + 1;
    }*/

    public static void main(String[] args) {
        new LeetCode26().removeDuplicates(new int[]{1, 1, 2});
    }

    private int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0, j;
        for (j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i += 1;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
