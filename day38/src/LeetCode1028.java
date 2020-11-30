/**
 * @author Zixiang Hu
 * @description 1028. 从先序遍历还原二叉树
 * @create 2020-06-19-21:35
 */
public class LeetCode1028 {
    class Solution {
        int cur = 0;
        int d = 0;

        public TreeNode recoverFromPreorder(String S) {
            return dfs(S, 0);
        }

        private TreeNode dfs(String s, int depth) {
            d = 0;
            int val = 0;
            while (cur < s.length() && s.charAt(cur) != '-') {
                val = val * 10 + s.charAt(cur++) - '0';
            }
            while (cur < s.length() && s.charAt(cur) == '-') {
                d++;
                cur++;
            }
            TreeNode root = new TreeNode(val);
            if (d > depth)
                root.left = dfs(s, d);
            if (d > depth)
                root.right = dfs(s, d);
            return root;
        }
    }
}
