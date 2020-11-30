import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 77. 组合
 * @create 2020-09-08-8:46
 */
public class LeetCode77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(n, k, 1, new ArrayList<>(), ans);
            return ans;
        }

        private void dfs(int n, int k, int start, ArrayList<Integer> list, List<List<Integer>> ans) {
            if (list.size() >= k) {
                ans.add(new ArrayList<>(list));
            } else {
                for (int i = start; i <= n; i++) {
                    list.add(i);
                    dfs(n, k, i + 1, list, ans);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
