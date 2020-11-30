import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 54. 螺旋矩阵
 * @create 2020-06-28-19:38
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return ans;
        int right = matrix[0].length - 1, left = 0;
        int top = 0, bottom = matrix.length - 1;
        while (left <= right && bottom >= top) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && left <= right && bottom >= top; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && left <= right && bottom >= top; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && left <= right && bottom >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode54().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }
}
