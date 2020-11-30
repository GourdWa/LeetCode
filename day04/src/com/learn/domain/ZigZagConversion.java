package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-10  16:20
 * @description LeetCode 6
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int internal = numRows - 2;
        int sLen = s.length();
        int pos;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            pos = i;
            if (pos == 0 || pos == numRows - 1) {
                while (pos < sLen) {
                    sb.append(s.charAt(pos));
                    pos += numRows + internal;
                }
            } else {
                while (pos < sLen) {
                    sb.append(s.charAt(pos));
                    if (pos + (numRows - 1 - i) * 2 < sLen)
                        sb.append(s.charAt(pos + (numRows - 1 - i) * 2));
                    pos += numRows + internal;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ZigZagConversion().convert("0123456789", 2));
    }
}
