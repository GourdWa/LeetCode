/**
 * @author Zixiang Hu
 * @description 845. 数组中的最长山脉
 * @create 2020-09-19-9:44
 */
public class LeetCode845 {
    class Solution {
        public int longestMountain(int[] A) {
            int[] left = new int[A.length];
            int[] right = new int[A.length];
            int maxSum = 0;
            for (int i = 1; i < A.length - 1; i++) {
                if (A[i] > A[i - 1]) {
                    left[i] = left[i - 1] + 1;
                }
                if (A[A.length - i - 1] > A[A.length - i])
                    right[A.length - i - 1] = right[A.length - i] + 1;
            }
            for (int i = 1; i < A.length - 1; i++) {
                if (left[i] != 0 && right[i] != 0) {
                    maxSum = maxSum > left[i] + right[i] ? maxSum : left[i] + right[i] + 1;
                }
            }
            return maxSum;
        }
    }
}
