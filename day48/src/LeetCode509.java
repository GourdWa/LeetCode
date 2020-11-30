import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description 509. 斐波那契数
 * @create 2020-07-02-15:13
 */
public class LeetCode509 {
    class Solution {
        public int fib(int N) {
            if (N == 0)
                return 0;
            int[] arr = new int[N + 1];
            Arrays.fill(arr, -1);
            arr[0] = 0;
            arr[1] = 1;
            recursion(arr, N);
            return arr[N];
        }
        private int recursion(int[] arr, int n) {
            if (arr[n] != -1)
                return arr[n];
            int ans = recursion(arr, n - 1) + recursion(arr, n - 2);
            arr[n] = ans;
            return ans;
        }
    }
}
