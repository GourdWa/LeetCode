import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 127. 单词接龙
 * @create 2020-11-05-9:04
 */
public class LeetCode127 {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if (!wordList.contains(endWord)) {
                return 0;
            }
            boolean[] visited = new boolean[wordList.size()];
            if (wordList.indexOf(beginWord) != -1) {
                visited[wordList.indexOf(beginWord)] = true;
            }
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            int cnt = 0;
            while (!queue.isEmpty()) {
                cnt++;
                int size = queue.size();
                while (size-- > 0) {
                    String pollString = queue.poll();
                    for (int i = 0; i < wordList.size(); i++) {
                        if (visited[i]) {
                            continue;
                        }
                        String s = wordList.get(i);
                        if (!convert(pollString, s)) {
                            continue;
                        }
                        if (s.equals(endWord)) {
                            return cnt + 1;
                        }
                        visited[i] = true;
                        queue.add(s);
                    }
                }
            }
            return 0;
        }

        private boolean convert(String t, String s) {
            int diff = 0;
            for (int i = 0; i < t.length() && diff < 2; i++) {
                if (t.charAt(i) != s.charAt(i)) {
                    diff++;
                }
            }
            return diff == 1;
        }
    }
}
