/**
 * @author Zixiang Hu
 * @description 459. 重复的子字符串
 * @create 2020-08-24-8:45
 */
public class LeetCode459 {
    static class Solution {
        //暴力
/*        public boolean repeatedSubstringPattern(String s) {
            for (int i = 1; i <= s.length() / 2; i++) {
                if (s.length()%i==0) {
                    String substring = s.substring(0, i);
                    StringBuilder sb = new StringBuilder(substring);
                    while (sb.length() < s.length()) {
                        if (s.startsWith(sb.toString())) {
                            sb.append(substring);
                        } else {
                            break;
                        }
                    }
                    
                    if (sb.length() == s.length() && s.equals(sb.toString()))
                        return true;
                }
            }
            return false;
        }*/
        //利用KMP算法
        public boolean repeatedSubstringPattern(String s) {
            String ss = s + s;
            return helper(ss.substring(1, ss.length() - 1), s);
        }

        private boolean helper(String s, String p) {
            int[] next = getNext(p);
            int i = 0, j = 0;
            while (i < s.length() && j < p.length()) {
                if (j == -1 || s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            return j == p.length();
        }

        private int[] getNext(String p) {
            int[] next = new int[p.length()];
            next[0] = -1;
            int i = 0, j = -1;
            while (i < p.length() - 1) {
                if (j == -1 || p.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                    next[i] = j;
                } else {
                    j = next[j];
                }
            }
            return next;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("abac"));
    }
}
