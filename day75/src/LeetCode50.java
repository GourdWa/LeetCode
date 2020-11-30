/**
 * @author Zixiang Hu
 * @description 50. Pow(x, n)
 * @create 2020-08-26-16:26
 */
public class LeetCode50 {
    static class Solution {
        public double helper(double x, int n) {
            if (n == 0)
                return 1;
            boolean isOdd = n % 2 != 0;
            double tempVal = helper(x, n / 2);
            if (isOdd)
                return x * tempVal * tempVal;
            else
                return tempVal * tempVal;
        }

        public double myPow(double x, int n) {
            return n < 0 ? 1.0 / helper(x, -n) : helper(x, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 10));
    }
}
