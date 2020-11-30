import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 144. 二叉树的前序遍历
 * @create 2020-10-27-8:40
 */
public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null)
            return list;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode popNode = stack.pop();
            root = popNode.right;
        }
        return list;
    }
}
