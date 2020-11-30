import java.util.Arrays;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 52. N皇后 II
 * @create 2020-10-17-9:38
 */
public class LeetCode51 {
    class Solution {
        private int ans = 0;

        public int totalNQueens(int n) {
            int[] rows = new int[n];
            dfs(0, rows);
            return ans;
        }

        private void dfs(int n, int[] rows) {
            if (n == rows.length) {
                ans++;
            } else {
                //传入的n代表前[0~n)行的皇后已经摆放好了，rows[n]代表第n行皇后摆放的列
                //枚举列
                for (int i = 0; i < rows.length; i++) {
                    int j;
                    //[0~n)行之间是否有皇后放在第i列与第i列在对角线上
                    for (j = 0; j < n; j++) {
                        if (rows[j] == i || (Math.abs(n - j) == Math.abs(i - rows[j]))) {
                            break;
                        }
                    }
                    //如果成功枚举到最后n行，说明第n行第i列可以放皇后
                    if (j == n) {
                        rows[n] = i;
                        dfs(n + 1, rows);
                    }
                }
            }
        }
    }
}
