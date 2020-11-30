import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 78. 子集
 * @create 2020-09-20-16:57
 */
public class LeetCode78 {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            if (nums != null && nums.length != 0) {
                for (int i = 1; i <= nums.length; i++) {
                    dfs(nums, i, 0, new ArrayList<>(), lists);
                }
            }
            lists.add(new ArrayList<>());
            return lists;
        }

        private void dfs(int[] nums, int len, int i, ArrayList<Integer> list, List<List<Integer>> lists) {
            if (list.size() >= len) {
                lists.add(new ArrayList<>(list));
            } else {
                for (int j = i; j < nums.length; j++) {
                    list.add(nums[j]);
                    // j+1是为了去重
                    dfs(nums, len, j + 1, list, lists);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}
