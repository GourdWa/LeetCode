import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 39. 组合总和
 * @create 2020-07-23-18:41
 */
public class LeetCode39 {
    static class Solution {
        int[] nums;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(candidates);
            nums = new int[target / candidates[0]];
            dfs(lists, candidates, target, 0, 0, 0);
            return lists;
        }

        private void dfs(List<List<Integer>> lists, int[] candidates, int target, int sum, int pos, int start) {

            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < pos; i++) {
                    list.add(nums[i]);
                }
                lists.add(list);
                return;
            }
            if (sum > target || pos >= nums.length)
                return;
            for (int i = start; i < candidates.length; i++) {
                nums[pos] = candidates[i];
                dfs(lists, candidates, target, sum + candidates[i], pos + 1, i);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
