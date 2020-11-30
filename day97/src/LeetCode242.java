/**
 * @author Zixiang Hu
 * @description 242. 有效的字母异位词
 * @create 2020-11-22-10:00
 */
public class LeetCode242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] chs = new int[26];
            for (int i = 0; i < s.length(); i++) {
                chs[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                chs[t.charAt(i) - 'a']--;
            }
            for (int ch : chs) {
                if (ch != 0)
                    return false;
            }
            return true;
        }
    }
}
