/**
 * @author Zixiang Hu
 * @description 100. 相同的树
 * @create 2020-08-07-8:47
 */
public class LeetCode100 {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null)
                return true;
            if (p == null || q == null)
                return false;
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
