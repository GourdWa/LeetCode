/**
 * @author Zixiang Hu
 * @description 112. 路径总和
 * @create 2020-07-07-17:14
 */
public class LeetCode112 {
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null)
                return false;
            if (root.left == null && root.right == null)
                return root.val == sum;
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
