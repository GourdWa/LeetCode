package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-11  16:46
 * @description 整数反转
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (Integer.MIN_VALUE == x)
            return 0;
        int ans = 0;
        int temp = Math.abs(x);
        while (temp != 0) {
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10))
                return 0;
            if (x < 0 && (ans > Integer.MIN_VALUE / -10 || (ans == Integer.MIN_VALUE / -10 && temp > -(Integer.MIN_VALUE % 10))))
                return 0;
            ans = ans * 10 + temp % 10;
            temp = temp / 10;
        }
        return x > 0 ? ans : -ans;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE / -10);
        System.out.println(-(Integer.MIN_VALUE % 10));
    }
}
