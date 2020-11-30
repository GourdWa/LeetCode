/**
 * @author Zixiang Hu
 * @description 67. 二进制求和
 * @create 2020-06-23-19:01
 */
public class LeetCode67 {
    class Solution {
        public String addBinary(String a, String b) {
            String res = "";
            boolean carry = false;
            int i = a.length() - 1, j = b.length() - 1;
            int sum;
            while (i >= 0 && j >= 0) {
                sum = a.charAt(i--) - '0' + b.charAt(j--) - '0';
                if (carry) {
                    res = (sum + 1) % 2 + res;
                    carry = (sum + 1) / 2 > 0;
                } else {
                    res = sum % 2 + res;
                    carry = sum / 2 > 0;
                }
            }
            while (i >= 0) {
                sum = a.charAt(i--) - '0';
                if (carry) {
                    res = (sum + 1) % 2 + res;
                    carry = (sum + 1) / 2 > 0;
                } else {
                    res = sum + res;
                }
            }
            while (j >= 0) {
                sum = b.charAt(j--) - '0';
                if (carry) {
                    res = (sum + 1) % 2 + res;
                    carry = (sum + 1) / 2 > 0;
                } else {
                    res = sum + res;
                }
            }
            if (carry)
                res = 1 + res;

            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("11",2));
    }
}
