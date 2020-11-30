import java.util.*;

/**
 * @author Zixiang Hu
 * @description 297. 二叉树的序列化与反序列化
 * @create 2020-09-27-17:09
 */
public class LeetCode297 {
    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode point = root;
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() || point != null) {
                while (point != null) {
                    sb.append(point.val);
                    sb.append(",");
                    stack.push(point);
                    point = point.left;
                }
                sb.append("null,");
                TreeNode popNode = stack.pop();
                point = popNode.right;
            }
            sb.append("null");
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split(",");
            Queue<String> queue = new LinkedList<>();
            for (String ele : split) {
                queue.add(ele);
            }
            return createTree(queue);
        }

        private TreeNode createTree(Queue<String> queue) {
            if (!queue.peek().equals("null")) {
                TreeNode node = new TreeNode(Integer.valueOf(queue.poll()));
                node.left = createTree(queue);
                node.right = createTree(queue);
                return node;
            }
            queue.poll();
            return null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        rightNode.left = new TreeNode(4);
        rightNode.right = new TreeNode(5);
        root.left = leftNode;
        root.right = rightNode;
        String serialize = new Codec().serialize(root);
        new Codec().deserialize(serialize);
        System.out.println();
    }

}
