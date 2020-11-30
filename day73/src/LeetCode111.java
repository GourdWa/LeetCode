import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 111. 二叉树的最小深度
 * @create 2020-08-21-8:50
 */
public class LeetCode111 {
    class Solution {
        // BFS，思路是层次遍历，遍历到叶子节点直接返回
/*        public int minDepth(TreeNode root) {
            if (root == null)
                return 0;
            int ans = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                ans++;
                while (size-- > 0) {
                    TreeNode pollEle = queue.poll();
                    if (pollEle.left == null && pollEle.right == null)
                        return ans;
                    if (pollEle.left != null)
                        queue.add(pollEle.left);
                    if (pollEle.right != null)
                        queue.add(pollEle.right);
                }
            }
            return ans;
        }*/
        // DFS
        public int minDepth(TreeNode root) {
            //如果根节点为空，返回深度0
            if (root == null)
                return 0;
            //如果根节点不为空，左右节点为空，返回1
            if (root.left == null && root.right == null)
                return 1;
            int l = minDepth(root.left);
            int r = minDepth(root.right);
            //如果根节点不为空，左右节点有一个为空，返回最大的深度
            if (root.left == null || root.right == null)
                return Math.max(l, r) + 1;
            //如果左右节点都不为空，返回最小的深度
            return Math.min(l, r) + 1;
        }
    }
}
