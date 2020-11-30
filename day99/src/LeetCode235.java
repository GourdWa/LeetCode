import java.lang.ref.SoftReference;

/**
 * @author Zixiang Hu
 * @description 235. 二叉搜索树的最近公共祖先
 * @create 2020-11-28-14:24
 */
public class LeetCode235 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode node = root;
            while (true) {
                if ((p.val >= node.val && q.val <= node.val) || (p.val <= node.val && q.val >= node.val))
                    return node;
                else if (p.val < node.val && q.val < node.val)
                    node = node.left;
                else
                    node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        ;
    }
}
