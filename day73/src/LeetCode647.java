/**
 * @author Zixiang Hu
 * @description 647. 回文子串
 * @create 2020-08-19-8:51
 */
public class LeetCode647 {
    static class Solution {
        //基本版，动态规划
        public int countSubstrings(String s) {
            if (s == null || s.length() == 0)
                return 0;
            int sLen = s.length();
            int ans = 0;
            boolean[][] dp = new boolean[sLen][sLen];
            for (int i = 0; i < sLen; i++) {
                for (int j = 0; j <= i; j++) {
                    if (i == j) {
                        dp[j][i] = true;
                        ans++;
                    } else if (s.charAt(i) == s.charAt(j)) {
                        if (i - j == 1 || dp[j + 1][i - 1]) {
                            dp[j][i] = true;
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aaaa"));
    }
}
