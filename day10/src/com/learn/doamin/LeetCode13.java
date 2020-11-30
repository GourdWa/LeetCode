package com.learn.doamin;

/**
 * @author ZixiangHu
 * @create 2020-05-17  13:35
 * @description
 */
public class LeetCode13 {
    public int romanToInt(String s) {
        char[] chs = s.toCharArray();
        int pre = getNum(chs[0]);
        int sum = 0;
        for (int i = 1; i < chs.length; i++) {
            int cur = getNum(chs[i]);
            if (cur > pre)
                sum -= pre;
            else
                sum += pre;
            pre = cur;
        }
        sum += pre;
        return sum;
    }

    public int getNum(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {

    }
}
