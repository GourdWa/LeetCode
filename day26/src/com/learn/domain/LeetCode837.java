package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-06-03  13:44
 * @description 837. 新21点
 */
public class LeetCode837 {
    public double new21Game(int N, int K, int W) {
        if (K == 0)
            return 1;
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i <= K + W - 1; i++)
            dp[i] = 1.0;
        int j = K - 1;

        for (int i = 1; i <= W; i++) {
            dp[j] += dp[j + i] / W;
        }
        j--;
        while (j >= 0) {
            dp[j] = (dp[j + 1] - dp[j + W + 1]) / W + dp[j + 1];
            j--;
        }
        return dp[0];
    }


}
