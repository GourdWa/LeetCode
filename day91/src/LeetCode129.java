/**
 * @author Zixiang Hu
 * @description 129. 求根到叶子节点数字之和
 * @create 2020-10-29-17:01
 */
public class LeetCode129 {
    //使用全局成员变量
/*    class Solution {
        private int ans = 0;
        private int value = 0;

        public int sumNumbers(TreeNode root) {
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode node) {
            if (node != null) {
                value = value * 10 + node.val;
                if (node.left == null && node.right == null)
                    ans += value;
                dfs(node.left);
                dfs(node.right);
                value = (value - node.val) / 10;
            }
        }
    }*/
    class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode node, int sum) {
            if (node == null)
                return 0;
            sum = sum * 10 + node.val;
            if (node.left == null && node.right == null)
                return sum;
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }
}
