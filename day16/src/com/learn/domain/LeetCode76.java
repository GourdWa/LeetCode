package com.learn.domain;

import java.util.Arrays;

/**
 * @author ZixiangHu
 * @create 2020-05-23  10:11
 * @description 76. 最小覆盖子串
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        int[] tArr = new int[128];
        for (char tChar : tChars) {
            tArr[tChar] += 1;
        }
        int start = 0;
        int end = 0;
        int left = 0;
        int right = 0;
        int num = 0;
        int minLen = s.length() + 1;
        while (right < s.length()) {
            tArr[sChars[right]]--;
            //如果大于等于0，说明sChars[right]这个字符存在于t中
            if (tArr[sChars[right]] >= 0)
                num++;
            while (num == t.length()) {
                if (right - left < minLen) {
                    start = left;
                    end = right+1;
                    minLen = right - left;
                }
                tArr[sChars[left]]++;
                if (tArr[sChars[left]] > 0) {
                    num--;
                }
                left++;
            }
            right++;
        }
        return s.substring(start, end);
    }
}
