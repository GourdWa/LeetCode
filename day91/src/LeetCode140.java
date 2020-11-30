import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 140. 单词拆分 II
 * @create 2020-11-01-18:40
 */
public class LeetCode140 {
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> ans = new ArrayList<>();
            List<String> list = new ArrayList<>();
            dfs(s, wordDict, ans, list, 0);
            return ans;
        }

        private void dfs(String s, List<String> wordDict, List<String> ans, List<String> list, int len) {
            if (len == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size() - 1; i++) {
                    sb.append(list.get(i)).append(" ");
                }
                sb.append(list.get(list.size() - 1));
                ans.add(sb.toString());
                return;
            }
            for (String word : wordDict) {
                if (len + word.length() <= s.length() && s.substring(len).startsWith(word)) {
                    list.add(word);
                    dfs(s, wordDict, ans, list, len + word.length());
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
