/**
 * @author Zixiang Hu
 * @description 96. 不同的二叉搜索树
 * @create 2020-07-15-18:38
 */
public class LeetCode96 {
    class Solution {
        public int numTrees(int n) {
            int[] dp = new int[1 + n];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    //长度为i，以j为根节点，左子树的数量为j-1；右子树为i-j
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
}
