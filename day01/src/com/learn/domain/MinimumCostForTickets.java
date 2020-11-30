package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-06  17:35
 * @description LEetCode 983
 */
public class MinimumCostForTickets {
    public static int mincostTickets(int[] days, int[] costs) {
        //dp[i]代表前i天的最低消费，比如dp[2]则代表前2天的最低消费为dp[2]
        int[] dp = new int[days[days.length - 1] + 1];
        int isDay = 0;
        for (int day = 1; day < dp.length; day++) {
            if (days[isDay] == day) {
                int money1 = dp[day - 1] + costs[0];
                int money2 = day > 7 ? dp[day - 7] + costs[1] : costs[1];
                int money3 = day > 30 ? dp[day - 30] + costs[2] : costs[2];
                dp[day] = Math.min(money1, Math.min(money2, money3));
                isDay++;
            } else
                dp[day] = dp[day - 1];
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] costs = new int[]{2, 7, 15};
        System.out.println(mincostTickets(days, costs));
    }
}
