package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-06-05  10:30
 * @description 面试题29. 顺时针打印矩阵
 */
public class LeetCode54 {
    private int[] output;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++)
                res[x++] = matrix[t][i]; // left to right.
            if (++t > b)
                break;
            for (int i = t; i <= b; i++)
                res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r)
                break;
            for (int i = r; i >= l; i--)
                res[x++] = matrix[b][i]; // right to left.
            if (t > --b)
                break;
            for (int i = b; i >= t; i--)
                res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r)
                break;
        }
        return res;
    }

/*    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[]{};
        output = new int[matrix.length * matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfs(matrix, visited, 0, 0, 0);
        return output;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int i, int j, int len) {
        if (len >= output.length)
            return;
        output[len] = matrix[i][j];
        visited[i][j] = true;
        if (j + 1 < matrix[0].length && i + 1 < matrix.length && !visited[i][j + 1] && !visited[i + 1][j]) {
            dfs(matrix, visited, i, j + 1, len + 1);
        } else if (j - 1 >= 0 && i - 1 >= 0 && !visited[i][j - 1] && !visited[i - 1][j]) {
            dfs(matrix, visited, i, j - 1, len + 1);
        } else if (j + 1 < matrix[0].length && i - 1 >= 0 && !visited[i][j + 1] && !visited[i - 1][j]) {
            dfs(matrix, visited, i - 1, j, len + 1);
        } else if (j - 1 >= 0 && i + 1 < matrix.length && !visited[i][j - 1] && !visited[i + 1][j]) {
            dfs(matrix, visited, i + 1, j, len + 1);
        } else if (j + 1 < matrix[0].length && !visited[i][j + 1])
            dfs(matrix, visited, i, j + 1, len + 1);
        else if (i + 1 < matrix.length && !visited[i + 1][j])
            dfs(matrix, visited, i + 1, j, len + 1);
        else if (j - 1 >= 0 && !visited[i][j - 1])
            dfs(matrix, visited, i, j - 1, len + 1);
        else if (i - 1 >= 0 && !visited[i - 1][j])
            dfs(matrix, visited, i - 1, j, len + 1);
    }*/
}
