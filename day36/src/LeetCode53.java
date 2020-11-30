/**
 * @author Zixiang Hu
 * @description
 * @create 2020-06-14-20:38
 */
public class LeetCode53 {
    //直接怼，类似贪心算法
/*    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
         *//*   if (sum < 0 && sum <= ans)
                sum = 0;
            else*//*
            if (sum > ans) {
                ans = sum;
//                sum = Math.max(0, sum);
            }
            sum = Math.max(0, sum);
        }
        return ans;
    }*/
    //动态规划，dp[i]代表以第i个元素结尾包含nums[i]的最大和
    //可知dp[i]的值取决于前面dp[i-1]的值，dp[i]等于dp[i-1]+nums[i]和nums[i]之间的较大者
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}
