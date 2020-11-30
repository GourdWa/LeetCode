/**
 * @author Zixiang Hu
 * @description 123. 买卖股票的最佳时机 III
 * @create 2020-07-11-14:30
 */
public class LeetCode123 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2)
                return 0;
            int profit1 = 0;
            int profit2 = 0;
            int lastMin = prices[0], nowMin = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int tempProfit = prices[i] - nowMin;
                if (tempProfit > profit1) {
                    if (tempProfit > profit2) {
                        profit1 = profit2;
                        profit2 = tempProfit;
                    } else
                        profit1 = tempProfit;
                }
                if (prices[i] < lastMin) {
                    lastMin = nowMin;
                    nowMin = prices[i];
                }
            }
            return profit1 + profit2;
        }
    }
}
