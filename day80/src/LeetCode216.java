import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 216. 组合总和 III
 * @create 2020-09-11-8:46
 */
public class LeetCode216 {
    class Solution {
        private int pos = 0;

        public List<List<Integer>> combinationSum3(int k, int n) {
            int[] nums = new int[k];
            List<List<Integer>> lists = new ArrayList<>();
            dfs(n, 0, 1, nums, lists);
            return lists;
        }

        private void dfs(int n, int sum, int start, int[] nums, List<List<Integer>> lists) {
            if (pos == nums.length) {
                if (sum == n) {
                    List<Integer> list = new ArrayList<>();
                    for (int num : nums) {
                        list.add(num);
                    }
                    lists.add(list);
                } else
                    return;
            } else {
                for (int i = start; i <= 9; i++) {
                    if (sum + i > n)
                        break;
                    nums[pos++] = i;
                    dfs(n, sum + i, i + 1, nums, lists);
                    pos--;
                }
            }
        }
    }
}
