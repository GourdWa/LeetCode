/**
 * @author Zixiang Hu
 * @description 96. 不同的二叉搜索树
 * @create 2020-07-21-15:49
 */
public class LeetCode96 {
   static class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(5));
    }
}
