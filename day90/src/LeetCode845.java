/**
 * @author Zixiang Hu
 * @description 845. 数组中的最长山脉
 * @create 2020-10-25-13:52
 */
public class LeetCode845 {
    static class Solution {
        public int longestMountain(int[] A) {
            if (A == null || A.length < 3)
                return 0;
            int[] left = new int[A.length];
            int[] right = new int[A.length];
            for (int i = 1; i < A.length - 1; i++) {
                if (A[i] > A[i - 1])
                    left[i] = left[i - 1] + 1;
                if (A[A.length - i - 1] > A[A.length - i])
                    right[A.length - i - 1] = right[A.length - i] + 1;
            }
            int ans = 0;
            for (int i = 1; i < A.length - 1; i++) {
                if (left[i] != 0 && right[i] != 0) {
                    ans = Math.max(ans, left[i] + right[i] + 1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new Solution().longestMountain(new int[]{2, 2, 2});
    }
}
