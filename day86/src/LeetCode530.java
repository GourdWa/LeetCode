/**
 * @author Zixiang Hu
 * @description 530. 二叉搜索树的最小绝对差
 * @create 2020-10-12-8:46
 */
public class LeetCode530 {
    class Solution {
        TreeNode preNode = null;
        int minAbs = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            inOrder(root);
            return minAbs;
        }

        private void inOrder(TreeNode node) {
            if (node != null) {
                inOrder(node.left);
                if (preNode != null)
                    minAbs = Math.min(minAbs, Math.abs(preNode.val - node.val));
                preNode = node;
                inOrder(node.right);
            }
        }
    }
}
