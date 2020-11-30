import java.util.*;

/**
 * @author Zixiang Hu
 * @description 378. 有序矩阵中第K小的元素
 * @create 2020-07-02-10:27
 */
public class LeetCode378 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int left = matrix[0][0];
            int right = matrix[n - 1][n - 1];
            while (left < right) {
                int mid = left + ((right - left) / 2);
                if (check(matrix, mid, k, n)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public boolean check(int[][] matrix, int mid, int k, int n) {
            int i = n - 1;
            int j = 0;
            int num = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= mid) {
                    num = num + i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            return num >= k;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                /*     {1, 3, 5, 7, 9, 11},
                     {2, 4, 6, 8, 10, 12},
                     {3, 5, 7, 9, 11, 13},
                     {4, 6, 8, 10, 12, 14},
                     {5, 7, 9, 11, 13, 15},
                     {6, 8, 10, 12, 16, 19}*/
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        new LeetCode378().new Solution().kthSmallest(arr, 8);
    }
}
