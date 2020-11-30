import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 104. 二叉树的最大深度
 * @create 2020-07-28-15:23
 */
public class LeetCode104 {
    class Solution {
        //递归
       /* public int maxDepth(TreeNode root) {
            if (root != null) {
                int l = maxDepth(root.left);
                int r = maxDepth(root.right);
                return Math.max(r, l) + 1;
            }
            return 0;
        }*/

        //BFS
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            int ans = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    TreeNode pollNode = queue.poll();
                    if (pollNode.left != null)
                        queue.offer(pollNode.left);
                    if (pollNode.right != null)
                        queue.offer(pollNode.right);
                }
                ans++;
            }
            return ans;
        }
    }
}
