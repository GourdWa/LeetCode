/**
 * @author Zixiang Hu
 * @description 718. 最长重复子数组
 * @create 2020-07-01-14:21
 */
public class LeetCode718 {
    //二维DP,类似于最长公共子串
    class Solution {
        public int findLength(int[] A, int[] B) {
            int ans = 0;
            int[][] dp = new int[A.length + 1][B.length + 1];
            for (int i = 1; i <= A.length; i++) {
                for (int j = 1; j <= B.length; j++) {
                    if (B[j - 1] == A[i - 1])
                        if ((j - 2 >= 0 && i - 2 >= 0 && B[j - 2] == A[i - 2]))
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                        else
                            dp[i][j] = 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    ans = Math.max(dp[i][j], ans);
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        new LeetCode718().new Solution().findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1, 0, 1, 0, 1});
    }
}
