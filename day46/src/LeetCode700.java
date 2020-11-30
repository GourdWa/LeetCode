/**
 * @author Zixiang Hu
 * @description 700. 二叉搜索树中的搜索
 * @create 2020-06-30-14:11
 */
public class LeetCode700 {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null)
                return null;
            if (root.val == val)
                return root;
            if (root.val > val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }
}
