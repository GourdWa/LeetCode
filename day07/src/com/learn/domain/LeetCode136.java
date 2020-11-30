package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-14  9:28
 * @description LeetCode 136 只出现一次的数字
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
