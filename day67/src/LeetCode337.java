import java.util.HashMap;
import java.util.Map;

/**
 * @author Zixiang Hu
 * @description 337. 打家劫舍 III
 * @create 2020-08-05-8:38
 */
public class LeetCode337 {
    class Solution {
        Map<TreeNode, Integer> map = new HashMap<>();

        //基本版
        /*
        public int rob(TreeNode root) {
            if (map.containsKey(root))
                return map.get(root);
            int ans = 0;
            if (root != null) {
                //val1代表使用根节点的值，那么下来只能只有左右孩子的左右孩子的值（也就是其孙子）
                int val1 = root.val;
                //val2代表不用根节点的值，但是累加左右孩子的值
                int val2 = 0;
                //val3代表不使用根节点的值，和不使用右孩子的值，但是使用左孩子的值和右孩子的孩子的值
                int val3 = 0;
                //val4代表不使用根节点的值，和不使用左孩子的值，但是使用右孩子的值和左孩子的孩子的值
                int val4 = 0;
                if (root.left != null) {
                    val1 += rob(root.left.left) + rob(root.left.right);
                    int t = rob(root.left);
                    val2 += t;
                    val3 += root.left.val;
                    val4 += t;
                }
                if (root.right != null) {
                    val1 += rob(root.right.left) + rob(root.right.right);
                    int t = rob(root.right);
                    val2 += t;
                    val3 += t;
                    val4 += root.right.val;
                }
                int max1 = Math.max(val1, val2);
                int max2 = Math.max(val3, val4);
                ans = Math.max(max1, max2);
            }
            map.put(root, ans);
            return ans;
        }
         */
        //改进版本
/*        public int rob(TreeNode root) {
            int ans = 0;
            if (root != null) {
                if (map.containsKey(root))
                    return map.get(root);
                int rootVal = root.val;
                int sonVal = 0;
                if (root.left != null) {
                    sonVal += rob(root.left);
                    rootVal += rob(root.left.left) + rob(root.left.right);
                }
                if (root.right != null) {
                    sonVal += rob(root.right);
                    rootVal += rob(root.right.left) + rob(root.right.right);
                }
                ans = Math.max(sonVal, rootVal);
            }
            map.put(root, ans);
            return ans;
        }*/
        public int rob(TreeNode root) {
            int[] res = helper(root);
            return Math.max(res[0], res[1]);
        }

        private int[] helper(TreeNode root) {
            if (root == null)
                return new int[]{0, 0};
            int[] result = new int[2];
            int[] left = helper(root.left);
            int[] right = helper(root.right);
            result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            result[1] = root.val + left[0] + right[0];
            return result;
        }
    }
}
