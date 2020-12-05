/**
 * @author Zixiang Hu
 * @description 221. 最大正方形
 * @create 2020-12-03-20:06
 */
public class LeetCode221 {
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return 0;
            int[][] dp = new int[matrix.length][matrix[0].length];
            int ans = 0;
            for (int i = 0; i < matrix.length; i++) {
                dp[i][0] = matrix[i][0] - '0';
                ans = Math.max(dp[i][0], ans);
            }
            for (int i = 0; i < matrix[0] .length; i++) {
                dp[0][i] = matrix[0][i] - '0';
                ans = Math.max(dp[0][i], ans);
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '0')
                        dp[i][j] = 0;
                    else {
                        int m = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                        dp[i][j] = (int) ((Math.sqrt(m) + 1) * (Math.sqrt(m) + 1));
                    }
                    ans = Math.max(dp[i][j], ans);
                }
            }
            return ans;
        }
    }
}
