import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 84. 柱状图中最大的矩形
 * @create 2020-12-04-17:08
 */
public class LeetCode84 {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Deque<Integer> stack = new LinkedList<>();
            int[] left = new int[heights.length];
            int[] right = new int[heights.length];
            for (int i = 0; i < heights.length; i++) {
                //如果栈顶元素大于当前遍历的元素，则弹出栈顶元素，直到栈顶为空或者栈顶元素小于当前元素
                //也就是构建单调递增的栈
                while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                    stack.pop();
                }
                if (stack.isEmpty())
                    left[i] = -1;
                else
                    left[i] = stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = heights.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                if (stack.isEmpty())
                    right[i] = heights.length;
                else
                    right[i] = stack.peek();
                stack.push(i);
            }
            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                int area = heights[i] * (right[i] - left[i] - 1);
                maxArea = Math.max(maxArea, area);
            }
            return maxArea;
        }
    }

    public static void main(String[] args) {

    }
}
