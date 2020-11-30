import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 297. 二叉树的序列化与反序列化
 * @create 2020-06-19-20:23
 */
public class LeetCode297 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

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
            String[] nodes = data.split(",");
            Queue<String> queue = new LinkedList<>();
            for (String node : nodes) {
                queue.add(node);
            }
            return createTree(queue);
        }

        private TreeNode createTree(Queue<String> queue) {
            String pollEle = queue.poll();
            if (!pollEle.equals("null")) {
                TreeNode root = new TreeNode(Integer.parseInt(pollEle));
                root.left = createTree(queue);
                root.right = createTree(queue);
                return root;
            }
            return null;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
