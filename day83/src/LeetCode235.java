/**
 * @author Zixiang Hu
 * @description 235. 二叉搜索树的最近公共祖先
 * @create 2020-09-27-8:59
 */
public class LeetCode235 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode res = root;
            while (res != null) {
                if (p.val == res.val || q.val == res.val)
                    break;
                if ((p.val > res.val && q.val < res.val) || (p.val < res.val && q.val > res.val))
                    break;
                if (p.val > res.val && q.val > res.val)
                    res = res.right;
                else if (p.val < res.val && q.val < res.val)
                    res = res.left;
            }
            return res;
        }
    }
}
