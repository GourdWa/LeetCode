import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 51. N 皇后
 * @create 2020-09-03-8:47
 */
public class LeetCode51 {
    static class Solution {
        List<List<String>> lists = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            int[] column = new int[n];
            dfs(0, column);
            return lists;
        }

        private void dfs(int row, int[] column) {
            if (row >= column.length) {
                List<String> list = new ArrayList<>();
                for (int col : column) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < column.length; i++) {
                        if (i != col)
                            sb.append('.');
                        else
                            sb.append('Q');
                    }
                    list.add(sb.toString());
                }
                lists.add(list);
            } else {
                //假设第row行的皇后摆放在第i列
                int i, j;
                for (i = 0; i < column.length; i++) {
                    for (j = 0; j < row; j++) {
                        //如果条件成立，说明第i列或i列的对角已经摆放了皇后。此时i肯定不符合要求
                        if (column[j] == i || Math.abs(row - j) == Math.abs(i - column[j])) {
                            break;
                        }
                    }
                    if (j == row) {
                        column[row] = i;
                        dfs(row + 1, column);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
