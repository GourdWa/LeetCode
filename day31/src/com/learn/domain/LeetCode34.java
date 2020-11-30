package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-06-08  16:58
 * @description 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class LeetCode34 {
/*    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                break;
            if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (high >= low) {
            int i = mid;
            int j = mid;
            while (i >= 0 && nums[i] == nums[mid]) i--;
            while (j <= nums.length - 1 && nums[j] == nums[mid]) j++;
            start = i + 1;
            end = j - 1;
        }
        return new int[]{start, end};
    }*/

    public int binarySerach(int[] nums, int target, boolean flag) {
        int low = 0;
        int high = nums.length - 1;
        while (high >= low) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target || (flag && nums[mid] == target))
                high = mid - 1;
            else
                low = mid + 1;
        }
        //搜索左边界
        if (flag && (low >= nums.length || nums[low] != target))
            return -1;
        else if (!flag && (high < 0 || nums[high] != target))
            return -1;
        return low;
    }

    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int left = binarySerach(nums, target, true);
        if (left != -1)
            start = left;
        int right = binarySerach(nums, target, false);
        if (right != -1)
            end = right;
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        new LeetCode34().searchRange(new int[]{1, 1, 1, 1, 1}, 1);
    }
}
