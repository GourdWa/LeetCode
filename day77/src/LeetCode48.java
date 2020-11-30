import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description 48. 旋转图像
 * @create 2020-09-03-9:51
 */
public class LeetCode48 {
    static class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        new Solution().rotate(ints);
        System.out.println();
    }
}
