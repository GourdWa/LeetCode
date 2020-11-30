package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-11  20:40
 * @description 回文数判断
 */
public class PalindromeNumber {
    /*    public boolean isPalindrome(int x) {
            String s = x + "";
            int len = s.length();
            int i = 0;
            while (len - i - 1 > i && s.charAt(len - i - 1) == s.charAt(i)) {
                i++;
            }
            return i >= len - i - 1;
        }*/
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;
        int reverseNum = 0;
        while (reverseNum < x) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return reverseNum == x || reverseNum / 10 == x;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(2112));
    }
}
