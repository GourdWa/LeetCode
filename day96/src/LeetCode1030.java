import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description 1030. 距离顺序排列矩阵单元格
 * @create 2020-11-17-8:55
 */
public class LeetCode1030 {
    class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int[][] mat = new int[R * C][2];
            int k = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    mat[k++] = new int[]{i, j};
                }
            }
            Arrays.sort(mat, (o1, o2) -> Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - Math.abs(o2[0] - r0) - Math.abs(o2[1] - c0));
            return mat;
        }
    }
}
