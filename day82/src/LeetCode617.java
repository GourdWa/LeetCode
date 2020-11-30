/**
 * @author Zixiang Hu
 * @description 617. 合并二叉树
 * @create 2020-09-23-9:18
 */
public class LeetCode617 {
    static class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null)
                return t2;
            if (t2 == null)
                return t1;

            return helper(t1, t2);
        }

        private TreeNode helper(TreeNode t1, TreeNode t2) {
            if (t1 != null && t2 != null) {
                TreeNode root = new TreeNode(t1.val + t2.val);
                root.left = helper(t1.left, t2.left);
                root.right = helper(t1.right, t2.right);
                return root;
            }
            return t1 == null ? t2 : t1;
        }
    }

    public static void main(String[] args) {
        new Solution().mergeTrees(null, new TreeNode(2));
    }
}
