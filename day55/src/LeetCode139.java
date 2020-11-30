import java.util.List;

/**
 * @author Zixiang Hu
 * @description 139. 单词拆分
 * @create 2020-07-09-18:37
 */
public class LeetCode139 {
    //dfs超时
/*    class Solution {
        private int len = 0;
        private boolean ans = false;

        public boolean wordBreak(String s, List<String> wordDict) {
            dfs(wordDict, s);
            return ans;
        }

        private void dfs(List<String> wordDict, String s) {
            if (len == s.length()) {
                ans = true;
                return;
            }
            if (!ans) {
                for (String word : wordDict) {
                    if (len + word.length() <= s.length() && s.substring(len).startsWith(word)) {
                        len += word.length();
                        dfs(wordDict, s);
                        len -= word.length();
                    }
                }
            }
        }
    }*/
    //dp
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            //dp[i]代表s的[0,i)个字符组成的子串能否被拆分成词典中的单词，
            // 例如dp[5]代表s.substring(0,5)这个子串能被拆分成字典中的单词
            int sLen = s.length();
            boolean[] dp = new boolean[sLen + 1];
            dp[0] = true;
            for (int i = 1; i <= sLen; i++) {
                for (String word : wordDict) {
                    int wordLen = word.length();
                    if (i >= wordLen && dp[i - wordLen] && s.substring(i - wordLen, i).equals(word))
                        dp[i] = true;
                }
            }
            return dp[sLen];
        }
    }
}
