package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-18  10:18
 * @description
 */
public class LeetCode152 {

    /*    public int maxProduct(int[] nums) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int tempMax = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    max = max>tempMax?max:tempMax;
                    tempMax *= nums[j];
                }
                max = max>tempMax?max:tempMax;
            }
            return max;
        }*/
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        max[0] = nums[0];
        min[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(max[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(min[i - 1] * nums[i],nums[i]);
            } else {
                max[i] = Math.max(min[i - 1] * nums[i], nums[i]);
                min[i] = Math.min(max[i - 1] * nums[i], nums[i]);
            }
        }
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, max[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
