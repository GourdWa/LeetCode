import java.util.*;

/**
 * @author Zixiang Hu
 * @description 98. 验证二叉搜索树
 * @create 2020-08-08-9:48
 */
public class LeetCode98 {
    class Solution {
        //1、中序遍历，判断是否存在逆序的情况
     /*   public boolean isValidBST(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) <= list.get(i - 1))
                    return false;
            }
            return true;
        }

        private void inOrder(TreeNode root, List<Integer> list) {
            if (root != null) {
                inOrder(root.left, list);
                list.add(root.val);
                inOrder(root.right, list);
            }
        }*/
        //2、使用非递归的中序遍历，边遍历边判断
  /*      public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            double preNodeVal = - Double.MAX_VALUE;
            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode popNode = stack.pop();
                if (popNode.val <= preNodeVal)
                    return false;
                preNodeVal = popNode.val;
                root = popNode.right;
            }
            return true;
        }*/
        // 3、递归
        public boolean helper(TreeNode node, Integer lower, Integer upper) {
            if (node == null) return true;

            int val = node.val;
            if (lower != null && val <= lower) return false;
            if (upper != null && val >= upper) return false;

            if (!helper(node.right, val, upper)) return false;
            if (!helper(node.left, lower, val)) return false;
            return true;
        }

        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }
    }
}
