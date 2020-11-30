import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 94. 二叉树的中序遍历
 * @create 2020-09-14-21:17
 */
public class LeetCode94 {
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> stack = new LinkedList<>();
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode popNode = stack.pop();
                list.add(popNode.val);
                root = popNode.right;
            }
            return list;
        }
    }
}
