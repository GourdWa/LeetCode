package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-06-02  8:24
 * @description 面试题64. 求1+2+…+n
 */
public class LeetCode64 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(11 << 3);
    }
}
