
/**
 * @author Zixiang Hu
 * @description 112. 路径总和
 * @create 2020-06-22-19:56
 */
public class LeetCode112 {
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            if (root.left == null && root.right == null && sum - root.val == 0)
                return true;
            if (root.left == null && root.right == null && sum - root.val != 0)
                return false;
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
