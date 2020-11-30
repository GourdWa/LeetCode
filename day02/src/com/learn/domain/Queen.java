package com.learn.domain;

import java.util.Arrays;

/**
 * @author ZixiangHu
 * @create 2020-05-07  23:09
 * @description LeetCode 52
 */
public class Queen {
    int[] cols;
    int cnt = 0;

    public int totalNQueens(int n) {
        cols = new int[n];
        Arrays.fill(cols, -1);
        queen(0, n);
        return cnt;
    }

    private void queen(int x, int n) {
        if (x == n) {
            cnt++;
            return;
        }

        //假设前x-1行已经放置好了皇后，现在放置第x行的皇后
        //x行的皇后可以放在0~n-1列
        int i, j;

        for (j = 0; j < n; j++) {
            //如果第x行的皇后放置在j列，查看其与前x-1行是否冲突
            for (i = 0; i < x; i++) {
                if (j == cols[i] || Math.abs(x - i) == Math.abs(j - cols[i])) {

                    break;
                }
            }
            if (i != x)
                continue;
            cols[x] = j;
            queen(x + 1, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Queen().totalNQueens(8));
    }
}
