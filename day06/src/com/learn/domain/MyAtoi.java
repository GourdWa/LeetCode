package com.learn.domain;

import java.time.chrono.IsoChronology;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZixiangHu
 * @create 2020-05-12  10:15
 * @description
 */
public class MyAtoi {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        char[] chs = str.toCharArray();
        int ans = 0;
        boolean isPositive = true;
        if (chs[0] == ' ' || (chs[0] >= '0' && chs[0] <= '9') || chs[0] == '+' || chs[0] == '-') {
            int i = 0;
            int len = chs.length;

            while (i < len && chs[i] == ' ')
                i += 1;
            //判断是否有正负号
            if (i < len && (chs[i] == '+' || chs[i] == '-')) {
                isPositive = (chs[i] != '-');
                i += 1;
            }
            while (i < len && (chs[i] >= '0' && chs[i] <= '9')) {
                int ele = chs[i] - '0';
                if (isPositive && ans > Integer.MAX_VALUE / 10)
                    return Integer.MAX_VALUE;
                else if (isPositive && ans == Integer.MAX_VALUE / 10 && ele > Integer.MAX_VALUE % 10)
                    return Integer.MAX_VALUE;
                else if (!isPositive && ans > -(Integer.MIN_VALUE / 10))
                    return Integer.MIN_VALUE;
                else if (!isPositive && ans == -(Integer.MIN_VALUE / 10) && -(Integer.MIN_VALUE % 10) < ele)
                    return Integer.MIN_VALUE;
                ans = ans * 10 + ele;
                i += 1;
            }
        }
        return isPositive ? ans : -ans;
    }

    public static void main(String[] args) {
        System.out.println(new MyAtoi().myAtoi("42"));
    }

}
