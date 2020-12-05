import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description 322. 零钱兑换
 * @create 2020-11-30-20:08
 */
public class LeetCode322 {
    static class Solution {
        //不加记忆化的dfs会超时
        public int coinChange(int[] coins, int amount) {
            int[] memo = new int[amount + 1];
            Arrays.fill(memo, -2);
            memo[0] = 0;
            return dfs(coins, amount, memo);
        }

        private int dfs(int[] coins, int amount, int[] memo) {
            if (amount < 0)
                return -1;
            if (memo[amount] != -2)
                return memo[amount];
            int ans = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = dfs(coins, amount - coin, memo);
                if (res != -1)
                    ans = Math.min(ans, res + 1);
            }
            if(ans == Integer.MAX_VALUE)
                ans = -1;
            memo[amount] = ans;
            return  memo[amount];
        }




/*        public int coinChange(int[] coins, int amount) {
            int[][] dp = new int[coins.length + 1][amount + 1];
            for (int i = 1; i <= amount; i++) {
                dp[0][i] = -1;
            }
            for (int i = 1; i <= coins.length; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (coins[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        //最多使用n个coins[i-1]硬币
                        int n = j / coins[i - 1];
                        dp[i][j] = dp[i - 1][j];
                        int minCnt = dp[i - 1][j] == -1 ? Integer.MAX_VALUE : dp[i - 1][j];
                        for (int k = 1; k <= n; k++) {
                            int sub = j - k * coins[i - 1];
                            //判断的目的是，使用了k个coins[i-1]硬币后，剩余的j-k * coins[i - 1]也能凑出来，不然的话这样兑换还是无意义
                            if (dp[i - 1][sub] != -1) {
                                minCnt = Math.min(minCnt, k + dp[i - 1][sub]);
                                dp[i][j] = minCnt;
                            }
                        }
                    }
                }
            }
            return dp[coins.length][amount];
        }*/
    }

    public static void main(String[] args) {
//        int[] coins = new int[]{1, 2, 5};
//        Solution solution = new Solution();
//        System.out.println(solution.coinChange(coins, 100));

    }
}
