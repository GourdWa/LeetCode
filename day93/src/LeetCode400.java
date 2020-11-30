/**
 * @author Zixiang Hu
 * @description 400. 第N个数字
 * @create 2020-11-08-20:48
 */
public class LeetCode400 {
    static class Solution {
        public int findNthDigit(int n) {
            //用于指示是是多少位数,比如[1,9]是1位数，[10,99]是2位数,[100,999]是3位数
            int i;
            for (i = 1; ; i++) {
                int t = (int) (9 * Math.pow(10, i - 1) * i);
                if (n < t)
                    break;
                n -= t;
            }
            //确实是第i位数字的第几个
            int no = n / i;
            //是否有余数
            int reminder = n % i;
            int startNum = (int) (no + Math.pow(10, i - 1) - 1);
            if (reminder == 0)
                return startNum % 10;
            startNum++;
            return String.valueOf(startNum).charAt(reminder - 1) - '0';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(15));
    }
}
