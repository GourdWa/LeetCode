import java.util.HashMap;
import java.util.Map;

/**
 * @author Zixiang Hu
 * @description 105. 从前序与中序遍历序列构造二叉树
 * @create 2020-06-23-20:03
 */
public class LeetCode105 {
    class Solution {
        int pos = 1;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0)
                return null;
            TreeNode root = new TreeNode(preorder[0]);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            root.left = createTree(0, map.get(preorder[0]) - 1, map, preorder, inorder);
            root.right = createTree(map.get(preorder[0]) + 1, preorder.length - 1, map, preorder, inorder);
            return root;
        }

        private TreeNode createTree(int l, int r, Map<Integer, Integer> map, int[] preorder, int[] inorder) {
            if (r >= l) {
                int val = preorder[pos++];
                TreeNode node = new TreeNode(val);
                node.left = createTree(l, map.get(val) - 1, map, preorder, inorder);
                node.right = createTree(map.get(val) + 1, r, map, preorder, inorder);
                return node;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        new LeetCode105().new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
