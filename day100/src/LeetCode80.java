import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Zixiang Hu
 * @description 85. 最大矩形
 * @create 2020-12-04-18:52
 */
public class LeetCode80 {
    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return 0;
            int ans = 0;
            int[][] heights = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i - 1 < 0)
                        heights[i][j] = matrix[i][j] - '0';
                    else
                        heights[i][j] = matrix[i][j] == '1' ? heights[i - 1][j] + 1 : 0;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                int[] height = heights[i];
                int[] left = new int[height.length];
                int[] right = new int[height.length];
                Deque<Integer> stack = new LinkedList<>();
                for (int j = 0; j < height.length; j++) {
                    while (!stack.isEmpty() && height[stack.peek()] >= height[j])
                        stack.pop();
                    left[j] = stack.isEmpty() ? -1 : stack.peek();
                    stack.push(j);
                }
                stack.clear();
                for (int j = height.length - 1; j >= 0; j--) {
                    while (!stack.isEmpty() && height[stack.peek()] >= height[j])
                        stack.pop();
                    right[j] = stack.isEmpty() ? height.length : stack.peek();
                    stack.push(j);
                }
                for (int j = 0; j < left.length; j++) {
                    int area = height[j] * (right[j] - left[j] - 1);
                    ans = Math.max(ans, area);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = new char[][]
                {{'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}};
        System.out.println(solution.maximalRectangle(matrix));
    }
}
