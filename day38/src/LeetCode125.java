/**
 * @author Zixiang Hu
 * @description 125. 验证回文串
 * @create 2020-06-19-21:08
 */
public class LeetCode125 {
    class Solution {
        public boolean isPalindrome(String s) {
            if (s == null || s.length() < 2)
                return true;
            int left = 0;
            int right = s.length() - 1;
            while (right >= left) {
                while (right >= left && !Character.isLetterOrDigit(s.charAt(right)))
                    right--;
                while (right >= left && !Character.isLetterOrDigit(s.charAt(left)))
                    left++;
                if (left > right)
                    return true;
                if ((s.charAt(left) >= '0' && s.charAt(left) <= '9') && s.charAt(left) != s.charAt(right))
                    return false;
                if (Character.isLetter(s.charAt(left)) && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                    return false;
                left++;
                right--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        new LeetCode125().new Solution().isPalindrome("A man, a plan, a canal: Panama");
    }
}
