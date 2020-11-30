/**
 * @author Zixiang Hu
 * @description 343. 整数拆分
 * @create 2020-07-30-9:31
 */
public class LeetCode343 {
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i < n; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    int diff = i - j;
                    int prod1 = Math.max(diff * j, dp[diff] * dp[j]);
                    int prod2 = Math.max(diff * dp[j], dp[diff] * j);
                    dp[i] = Math.max(Math.max(prod1, prod2), dp[i]);
                }
            }
            return dp[n];
        }
    }
}
