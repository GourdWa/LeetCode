/**
 * @author Zixiang Hu
 * @description 404. 左叶子之和
 * @create 2020-09-19-8:14
 */
public class LeetCode404 {
    /*    class Solution {
            int sum = 0;
            TreeNode preNode = null;

            public int sumOfLeftLeaves(TreeNode root) {
                preOrder(root);
                return sum;
            }

            private void preOrder(TreeNode root) {
                if (root != null) {
                    preOrder(root.left);
                    if (preNode != null && preNode == root.left && preNode.left == null && preNode.right == null)
                        sum += preNode.val;
                    preNode = root;
                    preOrder(root.right);
                }
            }
        }*/
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            return sumOfLeftLeaves(root, false);
        }

        public int sumOfLeftLeaves(TreeNode root, boolean flag) {
            if (root == null) {
                return 0;
            }
            if (flag && root.left == null && root.right == null) {
                return root.val;
            }
            int leftSum = sumOfLeftLeaves(root.left, true);
            int rightSum = sumOfLeftLeaves(root.right, false);
            return leftSum + rightSum;
        }
    }
}
