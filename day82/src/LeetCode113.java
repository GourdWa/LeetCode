import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 113. 路径总和 II
 * @create 2020-09-26-11:26
 */
public class LeetCode113 {
    class Solution {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root != null) {
                sum -= root.val;
                list.add(root.val);
                if (root.left == null && root.right == null) {
                    if (sum == 0)
                        lists.add(new ArrayList<>(list));
                } else {
                    pathSum(root.left, sum);
                    pathSum(root.right, sum);
                }
                list.remove(list.size() - 1);
            }
            return lists;
        }
    }
}
