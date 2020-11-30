package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-08  23:41
 * @description LeetCode 221
 */
public class MaximalSquare {
/*    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int maxSide = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(1, maxSide);
                    int currentMin = Math.min(rows - i, cols - j);
                    for (int k = 1; k < currentMin; k++) {
                        if (matrix[i + k][j + k] == '0') {
                            break;
                        }
                        boolean flag = false;
                        for (int l = 0; l < k; l++) {
                            if (matrix[i + k][j + l] == '0' || matrix[i + l][j + k] == '0') {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag)
                            maxSide = Math.max(k + 1, maxSide);
                        else
                            break;
                    }
                }
            }
        }

        return maxSide * maxSide;
    }*/

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == '1')
                maxSide = 1;
            dp[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == '1')
                maxSide = 1;
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != '1')
                    dp[i][j] = 0;
                else {
                    int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    dp[i][j] = min + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '1'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
}
