package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-26  0:02
 * @description
 */
public class ReverseString {
    public static String reverseString(String s) {
        if (s.length() == 1)
            return s;
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcde"));
    }
}
