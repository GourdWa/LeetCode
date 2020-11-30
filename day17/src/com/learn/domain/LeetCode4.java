package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-24  10:03
 * @description 寻找两个正序数组的中位数
 */
public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                nums[p] = nums1[p1];
                p1++;
            } else {
                nums[p] = nums2[p2];
                p2++;
            }
            p++;
        }
        while (p1 < nums1.length) {
            nums[p] = nums1[p1];
            p1++;
            p++;
        }
        while (p2 < nums2.length) {
            nums[p] = nums2[p2];
            p2++;
            p++;
        }
        return nums.length % 2 == 0 ? (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0 : nums[nums.length / 2];
    }

    public static void main(String[] args) {
        new LeetCode4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }
}
