/**
 * @author Zixiang Hu
 * @description 32. 最长有效括号
 * @create 2020-07-04-10:11
 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i >= 1) {
                if (s.charAt(i - 1) == '(') {
                    if (i - 2 >= 0)
                        dp[i] = dp[i - 2] + 2;
                    else
                        dp[i] = 2;
                } else if (s.charAt(i - 1) == ')') {
                    int pos = i - 1 - dp[i - 1];
                    if (pos >= 0 && s.charAt(pos) == '(') {
                        if (pos - 1 >= 0)
                            dp[i] = dp[pos - 1] + 2 + dp[i - 1];
                        else
                            dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            ans = ans > dp[i] ? ans : dp[i];
        }
        return ans;
    }
}
