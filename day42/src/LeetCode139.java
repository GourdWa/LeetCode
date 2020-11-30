import java.util.List;

/**
 * @author Zixiang Hu
 * @description 139. 单词拆分
 * @create 2020-06-26-18:35
 */
public class LeetCode139 {
    /*
    dfs+回溯
    超时
    * */
/*    class Solution {
        private int pos = 0;
        private boolean ans = false;

        public boolean wordBreak(String s, List<String> wordDict) {
            dfs(s, wordDict);

            return ans;
        }

        private void dfs(String s, List<String> wordDict) {
            if (pos == s.length()) {
                ans =true;
                return;
            }
            if (!ans) {
                for (String word : wordDict) {
                    if (pos + word.length() <= s.length() && s.substring(pos).startsWith(word)) {
                        pos += word.length();
                        dfs(s, wordDict);
                        pos -= word.length();
                    }
                }
            }
        }
    }*/
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            //dp[i]代表s.substring(0,i)子串能被拆分成wordDict中的元素
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i < dp.length; i++) {
                //因为wordDict中的元素可以重复使用，因此每次需要遍历整个wordDict集合
                //当遍历到任意一个word时，且i>word.length()；此时dp[i]等于true的条件是：dp[i-word.length()]=true且
                // s.substring(i-word.length())与word相等
                for (String word : wordDict) {
                    if (i >= word.length() && dp[i - word.length()] && s.substring(i - word.length(), i).equals(word))
                        dp[i] = true;
                }
            }
            return dp[dp.length - 1];
        }
    }

}
