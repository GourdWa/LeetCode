package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-06-09  8:41
 * @description 面试题46. 把数字翻译成字符串
 */
public class LeetCode46 {
    public int translateNum(int num) {
        if (num < 10)
            return 1;
        String nums = String.valueOf(num);
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        if (nums.charAt(0) > '2' || (nums.charAt(0) == '2' && nums.charAt(1) > '5'))
            dp[1] = 1;
        else
            dp[1] = 2;
        for (int i = 2; i < nums.length(); i++) {
            if (nums.charAt(i - 1) > '2' || (nums.charAt(i - 1) == '2' && nums.charAt(i) > '5'))
                dp[i] = dp[i - 1];
             else if (nums.charAt(i - 1) != '0')
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i - 1];
        }
        return dp[nums.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode46().translateNum(624));
    }
}
