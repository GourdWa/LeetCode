import java.util.List;

/**
 * @author Zixiang Hu
 * @description 139. 单词拆分
 * @create 2020-11-01-18:27
 */
public class LeetCode139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int sLen = s.length();
            boolean[] dp = new boolean[sLen + 1];
            dp[0] = true;
            for (int i = 1; i <= sLen; i++) {
                for (String word : wordDict) {
                    int wordLen = word.length();
                    if (i >= wordLen && dp[i - wordLen] && s.substring(i - wordLen).startsWith(word)) {
                        dp[i] = true;
                    }
                }
            }
            return dp[sLen];
        }
    }
}
