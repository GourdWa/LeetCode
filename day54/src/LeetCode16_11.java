import java.util.*;

/**
 * @author Zixiang Hu
 * @description 面试题 16.11. 跳水板
 * @create 2020-07-08-19:06
 */
public class LeetCode16_11 {
    //    dfs超时
/*    class Solution {
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0)
                return new int[]{};
            if (shorter == longer)
                return new int[]{k * longer};
            List<Integer> list = new ArrayList<>();

            dfs(shorter, longer, 0, k, 0, list);

            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }

        private void dfs(int shorter, int longer, int i, int k, int sum, List<Integer> list) {
            if (i == k) {
                if (!list.contains(sum))
                    list.add(sum);
                return;
            } else {
                dfs(shorter, longer, i + 1, k, sum + shorter, list);
                dfs(shorter, longer, i + 1, k, sum + longer, list);
            }
        }
    }*/
    class Solution {
        public int[] divingBoard(int shorter, int longer, int k) {
            if (k == 0)
                return new int[]{};
            if (longer == shorter)
                return new int[]{k * shorter};
            int[] ans = new int[k + 1];
            for (int i = 0; i <= k; i++) {
                ans[i] = i * longer + (k-i)*shorter;
            }
            return ans;
        }
    }
}
