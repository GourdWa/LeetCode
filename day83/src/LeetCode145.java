import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 145. 二叉树的后序遍历
 * @create 2020-09-29-8:41
 */
public class LeetCode145 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            if (root != null)
                stack.push(root);
            TreeNode preNode = null;
            while (!stack.isEmpty()) {
                TreeNode peekEle = stack.peek();
                if ((peekEle.left == null && peekEle.right == null) ||
                        (preNode != null && (preNode == peekEle.right || preNode == peekEle.left))) {
                    TreeNode popEle = stack.pop();
                    list.add(popEle.val);
                    preNode = peekEle;
                    continue;
                }
                if (peekEle.right != null)
                    stack.push(peekEle.right);
                if (peekEle.left != null)
                    stack.push(peekEle.left);
            }
            return list;
        }
    }
}
