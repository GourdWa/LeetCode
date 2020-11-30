/**
 * @author Zixiang Hu
 * @description 226. 翻转二叉树
 * @create 2020-09-16-16:59
 */
public class LeetCode226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            helper(root);
            return root;
        }

        private void helper(TreeNode root) {
            if (root != null) {
                helper(root.left);
                helper(root.right);
                TreeNode node = root.left;
                root.left = root.right;
                root.right = node;
            }
        }
    }
}
