import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zixiang Hu
 * @description 454. 四数相加 II
 * @create 2020-11-27-9:08
 */
public class LeetCode454 {
    static class Solution {
        //dfs+记忆化超时
  /*      public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int[][] arr = new int[][]{A, B, C, D};
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            return dfs(0, 0, arr, map);
        }

        public int dfs(int sum, int n, int[][] arr, Map<Integer, Map<Integer, Integer>> map) {
            int ret = 0;
            if (n == 4) {
                if (sum == 0)
                    return 1;
                return 0;
            }
            if (map.get(n) != null && map.get(n).containsKey(sum)) {
                return map.get(n).get(sum);
            }
            for (int i = 0; i < arr[0].length; i++) {
                int r = dfs(sum + arr[n][i], n + 1, arr, map);
                if (r > 0) {
                    Map<Integer, Integer> map1 = map.get(n + 1);
                    if (map1 == null)
                        map1 = new HashMap<>();
                    map1.put(sum + arr[n][i], r);
                    map.put(n + 1, map1);
                }
                ret += r;
            }
            return ret;
        }*/
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : A) {
                for (int b : B) {
                    map.put(a + b, map.getOrDefault(a + b, 0) + 1);
                }
            }
            for (int c : C) {
                for (int d : D) {
                    if (map.containsKey(-c - d))
                        ans += map.get(-c - d);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
