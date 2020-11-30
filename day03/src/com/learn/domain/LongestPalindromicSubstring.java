package com.learn.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-09  17:34
 * @description LeetCode 5. 最长回文子串
 */
public class LongestPalindromicSubstring {
    //暴力
 /*   public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        String ans = s.substring(0, 1);
        char[] chars = s.toCharArray();
        int strLen = 1;
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length - 1; j > i; j--) {
                if (isPalindromic(chars, i, j)) {
                    if (j - i + 1 > strLen) {
                        strLen = j - i + 1;
                        ans = s.substring(i, j + 1);
                    }
                    break;
                }
            }
        }
        return ans;
    }

    private boolean isPalindromic(char[] chs, int start, int end) {
        while (end > start) {
            if (chs[start] != chs[end])
                return false;
            end--;
            start++;
        }
        return true;
    }*/

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;
        char[] chs = s.toCharArray();
        int len = chs.length;
        int startSub = 0;
        int endSub = 0;
        int maxSubLen = 1;
        //dp[j][i]为true时，说明字符串j到i为回文串
        //如果dp[j+1][i-1]为true,即j+1到i-1为回文串，如果此时chs[j]==chs[i]；那么可以推出j到i为回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (chs[i] == chs[j] && ((i - j) <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > maxSubLen) {
                        maxSubLen = i - j + 1;
                        startSub = j;
                        endSub = i;
                    }
                }
            }
        }
        return s.substring(startSub, endSub + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("ac"));
    }
}
