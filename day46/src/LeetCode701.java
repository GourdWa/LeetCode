/**
 * @author Zixiang Hu
 * @description 701. 二叉搜索树中的插入操作
 * @create 2020-06-30-14:20
 */
public class LeetCode701 {
    class Solution {
        private TreeNode p = null;

        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null)
                return new TreeNode(val);
            findParentNode(root, val);
            if (p.val < val)
                p.right = new TreeNode(val);
            else
                p.left = new TreeNode(val);
            return root;
        }

        public void findParentNode(TreeNode root, int val) {
            if (root == null)
                return;
            if (root.val > val) {
                p = root;
                findParentNode(root.left, val);
            } else {
                p = root;
                findParentNode(root.right, val);
            }
        }
    }
}
