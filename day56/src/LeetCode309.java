/**
 * @author Zixiang Hu
 * @description 309. 最佳买卖股票时机含冷冻期
 * @create 2020-07-11-9:25
 */
public class LeetCode309 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2)
                return 0;
            //dp[i][0]代表第i天持有股票时的收益
            //dp[i][1]代表第i天不持有股票但是也不能买入（说明股票第i-1天卖出了）的收益
            //dp[i][2]代表第i天不持有股票同时能买入的收益
            int[][] dp = new int[prices.length][3];
            //第0天持有股票，说明在第0天买入了股票
            dp[0][0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                //第i天持有股票，说明要不在i-1天持有股票，或者在i-1天不持有股票但是不在冷冻期同时买入了股票
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
                //如果第i天不持有股票且在冷冻期，说明第i-1天持有股票但是卖出了股票
                dp[i][1] = dp[i - 1][0] + prices[i];
                //如果第i天不持有股票同时能买入，说明第i-1天不持有股票（当天卖出，在冷冻期dp[i-1][1]）或者第i-1天不持有股票（不在冷冻期）
                dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            }
            return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
        }
    }
}
