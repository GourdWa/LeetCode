package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-21  9:52
 * @description 最长回文串
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int left = 0;
        int right = 0;
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        left = j;
                        right = i;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        System.out.println("0123456".substring(0, 7));
    }
}
