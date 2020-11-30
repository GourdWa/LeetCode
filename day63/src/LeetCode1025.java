/**
 * @author Zixiang Hu
 * @description 1025. 除数博弈
 * @create 2020-07-24-8:36
 */
public class LeetCode1025 {
    class Solution {
        public boolean divisorGame(int N) {
            //dp[i]代表数字为i时，第一个人能否获胜。可知，dp[1]为false
            boolean[] dp = new boolean[N + 1];
            for (int i = 2; i <= N; i++) {
                for (int j = 1; j <= Math.sqrt(i); j++) {
                    if (i % j == 0 && !dp[i - j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[N];
        }
    }
}
