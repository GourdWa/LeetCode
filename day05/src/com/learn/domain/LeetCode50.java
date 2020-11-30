package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-11  15:46
 * @description LeetCode50 Pow(x,n)
 */
public class LeetCode50 {
    public double myPow(double x, int n) {
        return n > 0 ? powMethod(x, n) : 1.0 / powMethod(x, n);
    }

    private double powMethod(double x, int n) {
        if (n == 0)
            return 1;
        double y = powMethod(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;

    }

    public static void main(String[] args) {

    }
}
