/**
 * @author Zixiang Hu
 * @description 415. 字符串相加
 * @create 2020-08-03-8:32
 */
public class LeetCode415 {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            boolean carry = false;
            int i = num1.length() - 1, j = num2.length() - 1;
            while (i >= 0 || j >= 0) {
                int sum = 0;
                if (i >= 0)
                    sum = num1.charAt(i--) - '0';
                if (j >= 0)
                    sum += num2.charAt(j--) - '0';
                if (carry) {
                    sum += 1;
                }
                carry = sum >= 10;
                sb.append(sum % 10);
            }
            if (carry) {
                sb.append('1');
            }
            return sb.reverse().toString();
        }
    }
}
