import java.util.*;

/**
 * @author Zixiang Hu
 * @description 40. 组合总和 II
 * @create 2020-09-10-8:43
 */
public class LeetCode40 {
    static class Solution {
        private int pos = 0;

        /*        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
                    List<List<Integer>> lists = new ArrayList<>();
                    Set<List<Integer>> set = new HashSet<>();
                    Arrays.sort(candidates);
                    int[] nums = new int[target / candidates[0]];
                    dfs(candidates, target, nums, 0, 0, set);
                    return new ArrayList<>(set);
                }

                private void dfs(int[] candidates, int target, int[] nums, int sum, int start, Set<List<Integer>> set) {
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        for (int i = 0; i < pos; i++) {
                            list.add(nums[i]);
                        }
                        set.add(list);
                    } else {
                        for (int i = start; i < candidates.length; i++) {
                            if (sum + candidates[i] > target)
                                break;
                            nums[pos++] = candidates[i];
                            dfs(candidates, target, nums, sum + candidates[i], i + 1, lists);
                            pos--;
                        }
                    }
                }*/
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(candidates);
            int[] nums = new int[target / candidates[0]];
            dfs(candidates, target, nums, 0, 0, lists);
            return lists;
        }

        public void dfs(int[] candidates, int target, int[] nums, int sum, int start, List<List<Integer>> lists) {
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
                    // 技巧性去重，这里一定要是大于，不能包含等于
                    if (i > start && candidates[i] == candidates[i - 1])
                        continue;
                    nums[pos++] = candidates[i];
                    dfs(candidates, target, nums, sum + candidates[i], i + 1, lists);
                    pos--;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{1, 1, 2, 6, 5, 7, 10}, 8));
    }
}
