

/**
 * @author Zixiang Hu
 * @description 110. 平衡二叉树
 * @create 2020-08-17-8:57
 */
public class LeetCode110 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null)
                return true;
            if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
                return false;
            return isBalanced(root.right) && isBalanced(root.left);
        }

        private int getHeight(TreeNode node) {
            if (node != null) {
                int l = getHeight(node.left);
                int r = getHeight(node.right);
                return Math.max(l, r) + 1;
            }
            return 0;
        }
    }
}
