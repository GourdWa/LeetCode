import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zixiang Hu
 * @description 491. 递增子序列
 * @create 2020-08-25-8:49
 */
public class LeetCode491 {
    static class Solution {
        Set<List<Integer>> set = new HashSet<>();
        public List<List<Integer>> findSubsequences(int[] nums) {
            dfs(nums, 0, new ArrayList<Integer>());
            return new ArrayList<>(set);
        }

        private void dfs(int[] nums, int start, ArrayList<Integer> temp) {
            if (temp.size() > 1) {
                set.add(new ArrayList<>(temp));
            }
            for (int i = start; i < nums.length; i++) {
                if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
                    temp.add(nums[i]);
                    dfs(nums, i + 1, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{1, 2, 1, 1, 1, 1, 1}));
    }
}
