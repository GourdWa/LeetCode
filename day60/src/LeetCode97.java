/**
 * @author Zixiang Hu
 * @description 97. 交错字符串
 * @create 2020-07-18-20:05
 */
public class LeetCode97 {
    static class Solution {
        boolean ans = false;
        boolean[][] mark;

        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() == 0)
                return s2.equals(s3);
            if (s2.length() == 0)
                return s1.equals(s3);
            if (s3.length() == s1.length() + s2.length()) {
                mark = new boolean[s1.length()][s2.length()];
                dfs(s1, s2, s3, 0, 0, 0);
            }
            return ans;
        }

        private void dfs(String s1, String s2, String s3, int i, int j, int k) {
            if (k == s3.length()) {
                ans = true;
                return;
            }

            if (i >= s1.length()) {
                while (j < s2.length()) {
                    if (s2.charAt(j) != s3.charAt(k)) {
                        mark[i - 1][j] = true;
                        return;
                    }
                    j++;
                    k++;
                }
                ans = true;
                return;
            }
            if (j >= s2.length()) {
                while (i < s1.length()) {
                    if (s1.charAt(i) != s3.charAt(k)) {
                        mark[i][j - 1] = true;
                        return;
                    }
                    i++;
                    k++;
                }
                ans = true;
                return;
            }
            if (!mark[i][j]) {
                if (s3.charAt(k) == s1.charAt(i))
                    dfs(s1, s2, s3, i + 1, j, k + 1);
                if (s3.charAt(k) == s2.charAt(j))
                    dfs(s1, s2, s3, i, j + 1, k + 1);
                mark[i][j] = true;
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long start = System.currentTimeMillis();
        System.out.println(solution.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
        System.out.println(System.currentTimeMillis() - start);
    }
}
