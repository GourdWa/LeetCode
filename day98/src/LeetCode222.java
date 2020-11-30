/**
 * @author Zixiang Hu
 * @description 222. 完全二叉树的节点个数
 * @create 2020-11-24-9:41
 */
public class LeetCode222 {
    class Solution {
        public int countNodes(TreeNode root) {
            int ans = 0;
            if (root != null) {
                ans++;
                ans += countNodes(root.left);
                ans += countNodes(root.right);
            }
            return ans;
        }
    }
}
