package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-30  22:50
 * @description 29. 两数相除
 */
public class LeetCode29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean k = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        int result = 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        while (dividend <= divisor) {
            int temp = divisor;
            int c = 1;
            while (dividend - temp <= temp) {
                temp = temp << 1;
                c = c << 1;
            }
            dividend -= temp;
            result += c;
        }
        return k ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode29().divide(16, 3));
        System.out.println(3<<3);
    }
}
