/**
 * @author Zixiang Hu
 * @description 941. 有效的山脉数组
 * @create 2020-11-03-8:51
 */
public class LeetCode941 {
    class Solution {
        public boolean validMountainArray(int[] A) {
            //首先排除空数组，长度小于3和开始逆序的数组
            if (A == null || A.length < 3 || A[0] > A[1])
                return false;
            boolean peek = false;
            int i = 1;
            while (i < A.length) {
                if (A[i] == A[i - 1])
                    return false;
                if (!peek) {
                    if (A[i] > A[i - 1])
                        i++;
                    else
                        peek = true;
                } else {
                    if (A[i] < A[i - 1])
                        i++;
                    else
                        return false;
                }
            }
            return peek;
        }
    }
}
