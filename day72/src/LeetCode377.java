import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description 377. 组合总和 Ⅳ
 * @create 2020-08-18-14:54
 */
public class LeetCode377 {
    static class Solution {
        public int combinationSum4(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return 0;
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int num : nums) {
                    if (i >= num)
                        dp[i] += dp[i - num];
                }
            }
            return dp[target];
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum4(new int[]{1, 2, 4}, 7);
    }
}
