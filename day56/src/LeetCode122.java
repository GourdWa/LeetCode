/**
 * @author Zixiang Hu
 * @description 122. 买卖股票的最佳时机 II
 * @create 2020-07-10-16:54
 */
public class LeetCode122 {
    //使用波峰波谷方法，先找到波谷，再找到波峰
  /*  class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            if (prices.length < 2)
                return maxProfit;
            int low ;
            int high;
            int i = 0;
            while (i < prices.length - 1) {
//                找到低谷
                while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                    i++;
                low = prices[i];
//                找到高峰
                while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                    i++;
                high = prices[i];
                maxProfit = maxProfit + high - low;
            }
            return maxProfit;
        }
    }*/
//使用动态规划
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2)
                return 0;
            //dp[i][0]代表第i天持有股票时的最大收益
            //dp[i][1]代表第i天不持有股票，能买入股票的最大收益
            int[][] dp = new int[prices.length][2];
            //第0天持有股票的收益
            dp[0][0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                //第i天持有股票：1、第i-1天也持有股票；2、第i-1天不持有股票但是在第i天买入了股票
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
                //第i天不持有股票：1、第i-1天也不持有股票；2、第i-1天持有股票，但是在第i天将股票卖了
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            }
            return dp[prices.length - 1][1];
        }
    }

    public static void main(String[] args) {
        new LeetCode122().new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
