/**
 * @author Zixiang Hu
 * @description 538. 把二叉搜索树转换为累加树
 * @create 2020-09-21-8:48
 */
public class LeetCode538 {
    class Solution {
        TreeNode preNode = null;

        public TreeNode convertBST(TreeNode root) {
            helper(root);
            return root;
        }

        private void helper(TreeNode root) {
            if (root != null) {
                helper(root.right);
                if (preNode != null)
                    root.val += preNode.val;
                preNode = root;
                helper(root.left);
            }
        }
    }
}
