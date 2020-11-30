import java.util.*;

/**
 * @author Zixiang Hu
 * @description 47. 全排列 II
 * @create 2020-09-18-8:52
 */
public class LeetCode47 {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            if (nums == null || nums.length == 0)
                return new ArrayList<>();
            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];
            dfs(nums, 0, visited, new ArrayList<Integer>(), lists);
            return new ArrayList<>(lists);
        }

        private void dfs(int[] nums, int i, boolean[] visited, ArrayList<Integer> list, List<List<Integer>> lists) {
            if (i == nums.length) {
                lists.add(new ArrayList<>(list));
                return;
            } else {
                for (int j = 0; j < nums.length; j++) {
                    if (!visited[j]) {
                        if (j > 0 && nums[j - 1] == nums[j] && !visited[j - 1])
                            continue;
                        visited[j] = true;
                        list.add(nums[j]);
                        dfs(nums, i + 1, visited, list, lists);
                        list.remove(list.size() - 1);
                        visited[j] = false;
                    }
                }
            }
        }
    }
}
