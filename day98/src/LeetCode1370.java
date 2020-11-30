/**
 * @author Zixiang Hu
 * @description 1370. 上升下降字符串
 * @create 2020-11-25-9:12
 */
public class LeetCode1370 {
    static class Solution {
        public String sortString(String s) {
            int[] chs = new int[26];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                chs[s.charAt(i) - 'a']++;
            }
            while (sb.length() != s.length()) {
                StringBuilder temp = new StringBuilder();
                //先正序
                for (int i = 0; i < chs.length && sb.length() != s.length(); i++) {
                    if (chs[i] > 0) {
                        char c = (char) (i + 'a');
                        temp.append(c);
                        chs[i]--;
                    }
                }
                //后逆序
                for (int i = 25; i >= 0 && sb.length() != s.length(); i--) {
                    if (chs[i] > 0) {
                        char c = (char) (i + 'a');
                        temp.append(c);
                        chs[i]--;
                    }
                }
                sb.append(temp);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sortString("leetcode"));
    }
}
