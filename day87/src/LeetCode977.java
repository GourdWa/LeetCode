/**
 * @author Zixiang Hu
 * @description 977. 有序数组的平方
 * @create 2020-10-16-8:53
 */
public class LeetCode977 {
    class Solution {
        public int[] sortedSquares(int[] A) {
            int[] ans = new int[A.length];
            int left = 0, right = A.length - 1;
            int pos = A.length - 1;
            while (right >= left) {
                if (A[right] * A[right] > A[left] * A[left]) {
                    ans[pos] = A[right] * A[right];
                    right--;
                } else {
                    ans[pos] = A[left] * A[left];
                    left++;
                }
                pos--;
            }
            return ans;
        }
    }
}
