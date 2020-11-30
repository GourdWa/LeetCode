/**
 * @author Zixiang Hu
 * @description 392. 判断子序列
 * @create 2020-07-28-15:03
 */
public class LeetCode392 {
    static class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0)
                return true;
            if (t.length() == 0)
                return false;
            char[] chs = s.toCharArray();
            int tLen = t.length();
            int sLen = s.length();
            int pos = 0;
            for (int i = 0; i < tLen; i++) {
                if (t.charAt(i) == chs[pos])
                    pos++;
                if (pos == sLen)
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
    }
}
