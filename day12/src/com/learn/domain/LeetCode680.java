package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-19  9:03
 * @description 验证回文字符串 Ⅱ
 */
public class LeetCode680 {
    private int start;
    private int end;

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;
        end = s.length() - 1;
        start = 0;
        if (isPalindrome(s, start, end))
            return true;
        else {
            int tStart = start;
            int tEnd = end;
            return isPalindrome(s, start + 1, end) || isPalindrome(s, tStart, tEnd - 1);
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                this.start = start;
                this.end = end;
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode680().validPalindrome("puufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupu"));
    }
}
