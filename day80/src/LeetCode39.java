import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 39. 组合总和
 * @create 2020-09-09-8:53
 */
public class LeetCode39 {
    class Solution {
        private int pos = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(candidates);
            int[] nums = new int[target / candidates[0]];
            dfs(candidates, target, nums, 0, 0, lists);
            return lists;
        }

        private void dfs(int[] candidates, int target, int[] nums, int sum, int start, List<List<Integer>> lists) {
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < pos; i++) {
                    list.add(nums[i]);
                }
                lists.add(list);
            } else {
                for (int i = start; i < candidates.length; i++) {
                    if (sum + candidates[i] > target)
                        break;
                    nums[pos++] = candidates[i];
                    dfs(candidates, target, nums, sum + candidates[i], i, lists);
                    pos--;
                }
            }
        }
    }
}
