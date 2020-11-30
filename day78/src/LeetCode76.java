import java.util.HashMap;
import java.util.Map;

/**
 * @author Zixiang Hu
 * @description 76. 最小覆盖子串
 * @create 2020-09-06-14:38
 */
public class LeetCode76 {
    static class Solution {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() < t.length())
                return "";
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                if (!map.containsKey(t.charAt(i)))
                    map.put(t.charAt(i), 0);
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }
            int miniLen = s.length() + 1;
            int left = 0, right = 0;
            int start = 0, end = 0;
            int count = 0;
            while (right < s.length()) {
                char sCh = s.charAt(right);
                //如果是t中包含的字符
                if (map.containsKey(sCh)) {
                    //证明还未匹配完
                    if (map.get(sCh) > 0)
                        count++;
                    map.put(sCh, map.get(sCh) - 1);
                }
                while (count == t.length()) {
                    if (right - left < miniLen) {
                        start = left;
                        end = right + 1;
                        miniLen = right - left + 1;
                    }
                    //如果当前窗口最左边的字符是t串中的
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0)
                            count--;
                    }
                    left++;
                }
                right++;
            }
            return s.substring(start, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));

    }
}
