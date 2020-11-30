

/**
 * @author Zixiang Hu
 * @description 104. 二叉树的最大深度
 * @create 2020-06-23-19:33
 */
public class LeetCode104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root != null) {
                int lHeight = maxDepth(root.left);
                int rHeight = maxDepth(root.right);
                return Math.max(lHeight, rHeight) + 1;
            }
            return 0;
        }
    }
}
