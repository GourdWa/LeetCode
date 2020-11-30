/**
 * @author Zixiang Hu
 * @description 121. 买卖股票的最佳时机
 * @create 2020-07-10-20:48
 */
public class LeetCode121 {

        class Solution {
            public int maxProfit(int[] prices) {
                int maxProfit = 0;
                if (prices.length < 2)
                    return 0;
                maxProfit = prices[1] - prices[0] > 0 ? prices[1] - prices[0] : 0;
                int min = Math.min(prices[0], prices[1]);
                for (int i = 2; i < prices.length; i++) {
                    int profit = prices[i] - min;
                    if (profit > maxProfit)
                        maxProfit = profit;
                    min = Math.min(min, prices[i]);
                }
                return maxProfit;
            }
        }

}
