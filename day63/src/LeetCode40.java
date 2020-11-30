import java.util.*;

/**
 * @author Zixiang Hu
 * @description 40. 组合总和 II
 * @create 2020-07-24-14:10
 */
public class LeetCode40 {
    static class Solution {
        int[] nums;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(candidates);
            nums = new int[target / candidates[0]];
            dfs(lists, candidates, target, 0, 0, 0);
            return lists;
        }

        private void dfs(List<List<Integer>> lists, int[] candidates, int target, int pos, int sum, int start) {
            Set<Integer> set = new HashSet<>();
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < pos; i++) {
                    list.add(nums[i]);
                }
                lists.add(list);
                return;
            }
            if (pos >= nums.length || sum > target) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                if (!set.contains(candidates[i])) {
                    set.add(candidates[i]);
                    nums[pos] = candidates[i];
                    //注意这里和39题的区别，因为本题不能重复使用一个元素，因此用来第i个元素后只能用之后的元素
                    //而39题可以重复使用元素，因此使用了第i个元素之后，仍然可以使用第i个元素
                    dfs(lists, candidates, target, pos + 1, sum + candidates[i], i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode40.Solution().combinationSum2(new int[]{1, 1, 1, 3, 3, 5}, 8);
    }
}
