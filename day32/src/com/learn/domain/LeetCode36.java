package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-06-09  20:38
 * @description 36. 有效的数独
 */
public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    boolean[] temp = new boolean[9];
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            if (board[k][l] != '.') {
                                if (temp[board[k][l] - '1'])
                                    return false;
                                temp[board[k][l] - '1'] = true;
                            }
                        }
                    }
                }
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1'])
                        return false;
                    row[board[i][j] - '1'] = true;
                }

                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1'])
                        return false;
                    col[board[j][i] - '1'] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
        {'.','.','.','.','5','.','.','1','.'},
        {'.','4','.','3','.','.','.','.','.'},
        {'.','.','.','.','.','3','.','.','1'},
        {'8','.','.','.','.','.','.','2','.'},
        {'.','.','2','.','7','.','.','.','.'},
        {'.','1','5','.','.','.','.','.','.'},
        {'.','.','.','.','.','2','.','.','.'},
        {'.','2','.','9','.','.','.','.','.'},
        {'.','.','4','.','.','.','.','.','.'}
        };
        System.out.println(new LeetCode36().isValidSudoku(board));
    }
}
