package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-24  10:11
 * @description
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = 0;
        int maxLen = 1;
        int[] arr = new int[128];
        char[] chs = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < chs.length) {
            char ch = chs[right];
            if (arr[ch] == 1) {
                while (chs[left] != ch) {
                    arr[chs[left]] = 0;
                    left++;
                }
                arr[chs[left]] = 0;
                left++;
                len = right - left + 1;
            } else {
                len++;
                maxLen = Math.max(len, maxLen);
            }
            arr[ch] = 1;
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        new LeetCode3().lengthOfLongestSubstring("pwwkew");
    }
}
