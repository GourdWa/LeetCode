/**
 * @author Zixiang Hu
 * @description 214. 最短回文串
 * @create 2020-08-29-16:22
 */
public class LeetCode214 {
    static class Solution {
        public boolean isPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            while (r > l && s.charAt(l) == s.charAt(r)) {
                r--;
                l++;
            }
            return l >= r;
        }

        public String shortestPalindrome(String s) {
            if (isPalindrome(s))
                return s;
            //目的是找出以第一个字符为开端的最长回文子串
            int r = s.length() - 2;
            while (0 < r) {
                if (s.charAt(r) == s.charAt(0)) {
                    if (isPalindrome(s.substring(0, r + 1))) {
                        break;
                    }
                }
                r--;
            }
            String reverse = new StringBuilder(s.substring(r + 1)).reverse().toString();
            return reverse + s;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().shortestPalindrome("aacecaaa"));
    }
}
