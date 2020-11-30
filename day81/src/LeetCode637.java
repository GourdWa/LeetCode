import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 637. 二叉树的层平均值
 * @create 2020-09-12-11:40
 */
public class LeetCode637 {
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> list = new ArrayList<>();
            if (root == null)
                return list;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int n = size;
                double sum = 0;
                while (size-- > 0) {
                    TreeNode pollNode = queue.poll();
                    sum += pollNode.val;
                    if (pollNode.left != null)
                        queue.add(pollNode.left);
                    if (pollNode.right != null)
                        queue.add(pollNode.right);
                }
                list.add(sum / 1.0 / n);
            }
            return list;
        }
    }
}
