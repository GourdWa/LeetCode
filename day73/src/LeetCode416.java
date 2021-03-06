/**
 * @author Zixiang Hu
 * @description 416. 分割等和子集
 * @create 2020-08-19-17:32
 */
public class LeetCode416 {
    static class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 != 0)
                return false;
            int n = sum / 2;
            int[][] dp = new int[nums.length + 1][n + 1];
            for (int i = 0; i <= nums.length; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= nums[i - 1]) {
                        dp[i][j] += dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][n] != 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 2, 5}));

    }
}
