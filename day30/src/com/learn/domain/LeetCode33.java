package com.learn.domain;

import javax.sound.midi.Track;

/**
 * @author ZixiangHu
 * @create 2020-06-07  10:29
 * @description 33. 搜索旋转排序数组
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //如果满足左半边肯定是有序的
            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {//右半边是有序的
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
