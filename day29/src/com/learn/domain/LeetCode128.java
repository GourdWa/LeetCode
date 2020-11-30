package com.learn.domain;


import java.util.HashSet;

import java.util.Set;

/**
 * @author ZixiangHu
 * @create 2020-06-06  10:25
 * @description 128. 最长连续序列
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxLen = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num + 1;
                int len = 1;
                while (set.contains(curNum)) {
                    len++;
                    curNum++;
                }
                maxLen = maxLen > len ? maxLen : len;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        new LeetCode128().longestConsecutive(new int[]{2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645});
    }
}
