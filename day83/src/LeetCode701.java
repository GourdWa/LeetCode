/**
 * @author Zixiang Hu
 * @description 701. 二叉搜索树中的插入操作
 * @create 2020-09-30-8:59
 */
public class LeetCode701 {
    class Solution {
        TreeNode preNode = null;

        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null)
                return new TreeNode(val);
            TreeNode newRoot = root;
            findParent(root, val);
            if (preNode.val > val)
                preNode.left = new TreeNode(val);
            else
                preNode.right = new TreeNode(val);
            return newRoot;
        }

        private void findParent(TreeNode root, int val) {
            if (root == null)
                return;
            if (root.val > val) {
                preNode = root;
                root = root.left;
            } else if (root.val < val) {
                preNode = root;
                root = root.right;
            }
            findParent(root, val);
        }
    }
}
