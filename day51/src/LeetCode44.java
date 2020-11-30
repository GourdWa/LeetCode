/**
 * @author Zixiang Hu
 * @description 44. 通配符匹配
 * @create 2020-07-05-15:06
 */
public class LeetCode44 {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = p.charAt(j);
                if (ch == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i][j];
                } else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        isMatch("abdef", "a*f");
    }
}
