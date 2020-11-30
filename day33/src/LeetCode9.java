/**
 * @author ZixiangHu
 * @create 2020-06-10  10:22
 * @description 9. 回文数
 */
public class LeetCode9 {
    public boolean isPalindrome(int x) {
     /*   String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while (right >= left && s.charAt(left) == s.charAt(right)) {
            right--;
            left++;
        }
        return left > right;*/
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int reverseX = 0;
        int temp = x;
        while (temp != 0) {
            reverseX = reverseX * 10 + temp % 10;
            temp /= 10;
        }
        return reverseX == x;
    }
}
