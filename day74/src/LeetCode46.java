import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 46. 全排列
 * @create 2020-08-25-19:53
 */
public class LeetCode46 {
    static class Solution {
        List<List<Integer>> lists = new ArrayList<>();
        boolean[] flag;

        public List<List<Integer>> permute(int[] nums) {
            flag = new boolean[nums.length];
            dfs(nums, 0, new ArrayList<Integer>());
            return lists;
        }

        private void dfs(int[] nums, int start, ArrayList<Integer> list) {
            if (list.size() == nums.length) {
                lists.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (!flag[i]) {
                    list.add(nums[i]);
                    flag[i] = true;
                    dfs(nums, start, list);
                    list.remove(list.size() - 1);
                    flag[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().permute(new int[]{1, 2, 3});
    }
}
