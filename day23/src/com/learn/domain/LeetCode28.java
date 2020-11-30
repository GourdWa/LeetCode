package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-30  13:31
 * @description 实现KMP算法
 */
public class LeetCode28 {
    public int[] getNext(String ps) {
        int[] next = new int[ps.length()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < ps.length() - 1) {
            if (j == -1 || ps.charAt(i) == ps.charAt(j)) {
                j += 1;
                i += 1;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;

        char[] t = haystack.toCharArray();
        char[] p = needle.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(needle);
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                j = next[j]; // j回到指定位置
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        new LeetCode28().getNext("aaab");
    }
}
