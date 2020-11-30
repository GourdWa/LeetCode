/**
 * @author Zixiang Hu
 * @description 1014. 最佳观光组合
 * @create 2020-06-19-20:51
 */
public class LeetCode1014 {
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int preMax = A[0] + 0;
            int ans = 0;
            for (int i = 1; i < A.length; i++) {
                int nowDiff = A[i] - i;
                if (nowDiff + preMax > ans)
                    ans = nowDiff + preMax;
                preMax = preMax > A[i] + i ? preMax : A[i] + i;
            }
            return ans;
        }
    }

}
