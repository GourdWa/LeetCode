/**
 * @author Zixiang Hu
 * @description 343. 整数拆分
 * @create 2020-07-05-16:01
 */
public class LeetCode343 {
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    int diff = Math.max(i - j, dp[i - j]);
                    int temp = Math.max(dp[j], j);
                    dp[i] = Math.max(dp[i], diff * temp);
                }
            }
            return dp[n];
        }
    }
}
