/**
 * @author Zixiang Hu
 * @description 518. 零钱兑换 II
 * @create 2020-08-17-19:52
 */
public class LeetCode518 {
    class Solution {
        //
       /* public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= amount; j++) {
                    if (j - coins[i - 1] >= 0)
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    else
                        dp[i][j] = dp[i - 1][j];
                }
            }
            return dp[n][amount];
        }*/
        //

        //dp[i][j]的含义是：前i个硬币能凑成j元的组合数量。
        // 如果不用第i个硬币：前i个硬币组合出j元的数量=前i-1个硬币凑出j元+前i个硬币凑出j - k * coins[i - 1]元
        public int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            //注意，这里也是和完全背包的区别
            dp[0][0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= amount; j++) {
                    //这里和完全背包有区别
                    dp[i][j] = dp[i - 1][j];
                    for (int k = 1; k * coins[i - 1] <= j; k++) {
                        dp[i][j] = dp[i][j] + dp[i - 1][j - k * coins[i - 1]];
                    }
                }
            }
            return dp[n][amount];
        }
    }
}
