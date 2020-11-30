package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-08  10:08
 * @description LeetCode 1143 最长公共子序列
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int height = text1.length();
        int width = text2.length();
        int[][] matrix = new int[height + 1][width + 1];
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[height][width];
    }

    public static void main(String[] args) {
        String text1 = "abb";
        String text2 = "abcd";
        int commonSubsequence = new LongestCommonSubsequence().longestCommonSubsequence(text1, text2);
        System.out.println(commonSubsequence);
    }
}
