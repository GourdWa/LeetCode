import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 39. 组合总和
 * @create 2020-06-24-19:18
 */
public class LeetCode39 {
    class Solution {
        int pos = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            //因为数组元素全部是正整数，因此，每个集合最多包含的元素个数是target / minEle
            Arrays.sort(candidates);
            int[] nums = new int[target / candidates[0]];
            dfs(ans, candidates, nums, 0, target, 0);
            return ans;
        }

        /**
         * @param ans
         * @param candidates
         * @param nums
         * @param sum        元素和，当其等于target时说明nums中的元素满足要求，如果大于target说明不满足要求
         * @param target
         * @param start start的目的是剪枝去除重复
         */
        private void dfs(List<List<Integer>> ans, int[] candidates, int[] nums, int sum, int target, int start) {
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                for (int num : nums) {
                    if (num != 0)
                        temp.add(num);
                }
                ans.add(temp);
                return;
            }
            if (sum > target || pos >= nums.length)
                return;
            for (int i = start; i < candidates.length; i++) {
                nums[pos] = candidates[i];
                pos++;
                dfs(ans, candidates, nums, sum + candidates[i], target, i);
                pos--;
                nums[pos] = 0;
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode39().new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
