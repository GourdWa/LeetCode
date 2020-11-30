/**
 * @author Zixiang Hu
 * @description 122. 买卖股票的最佳时机 II
 * @create 2020-11-08-9:45
 */
public class LeetCode122 {
    static class Solution {
        /*  public int maxProfit(int[] prices) {
              if (prices == null || prices.length < 2)
                  return 0;
              int valley = 0, peak = 0;
              int profit = 0;
              int i = 0;
              //如果i等于prices.length - 1，此时已经不满足有波峰和波谷了
              while (i < prices.length - 1) {
                  while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                      i++;
                  valley = prices[i];
                  while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                      i++;
                  peak = prices[i];
                  profit = profit + peak - valley;
              }
              return profit;
          }*/
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2)
                return 0;
            int[][] dp = new int[prices.length][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[prices.length - 1][0];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{5, 2, 3, 2, 6, 6, 2, 9, 1, 0, 7, 4, 5, 0}));
    }
}
