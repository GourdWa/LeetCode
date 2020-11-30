/**
 * @author Zixiang Hu
 * @description 983. 最低票价
 * @create 2020-06-14-15:10
 */
public class LeetCode983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int j = 0;
        for (int i = 1; i < 366 && j < days.length; i++) {
            if (i == days[j]) {
                int day1 = dp[i - 1] + costs[0];
                int day7 = i - 7 >= 0 ? dp[i - 7] + costs[1] : costs[1];
                int day30 = i - 30 >= 0 ? dp[i - 30] + costs[2] : costs[2];
                dp[i] = Math.min(Math.min(day1, day7), day30);
                j++;
            } else
                dp[i] = dp[i - 1];
        }
        return dp[days[days.length - 1]];
    }

    public static void main(String[] args) {
        new LeetCode983().mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
    }
}
