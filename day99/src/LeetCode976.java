import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description 976. 三角形的最大周长
 * @create 2020-11-29-10:09
 */
public class LeetCode976 {
    class Solution {
        public int largestPerimeter(int[] A) {
            if (A == null || A.length < 3)
                return 0;
            Arrays.sort(A);
            int i = A.length - 3;
            while (i >= 0) {
                if (A[i] + A[i + 1] > A[i + 2])
                    return A[i] + A[i + 1] + A[i + 2];
                i--;
            }
            return 0;
        }
    }
}
