import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 257. 二叉树的所有路径
 * @create 2020-09-04-8:43
 */
public class LeetCode257 {
    static class Solution {
        StringBuilder sb = new StringBuilder();

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            preOrder(root, list);
            return list;
        }

        private void preOrder(TreeNode root, List<String> list) {
            if (root != null) {
                int start = sb.length();
                if (root.left == null && root.right == null) {
                    sb.append(root.val);
                    list.add(new String(sb));
                    sb.delete(start, sb.length());
                    return;
                }

                sb.append(root.val).append("->");
                preOrder(root.left, list);
                preOrder(root.right, list);
                sb.delete(start, sb.length());
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(37);
        TreeNode treeNode1 = new TreeNode(-34);
        treeNode1.right = new TreeNode(-100);
        root.left = treeNode1;
        root.right = new TreeNode(-48);
        System.out.println(new Solution().binaryTreePaths(root));
    }
}
