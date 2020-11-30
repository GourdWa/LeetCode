import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 99. 恢复二叉搜索树
 * @create 2020-08-08-9:28
 */
public class LeetCode99 {
    class Solution {
        public void recoverTree(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            int[] swapped = findTwoSwapped(list);
            recover(root, swapped);
        }

        private void recover(TreeNode root, int[] swapped) {
            if (root != null) {
                if (root.val == swapped[0])
                    root.val = swapped[1];
                else if (root.val == swapped[1])
                    root.val = swapped[0];
                recover(root.left, swapped);
                recover(root.right, swapped);
            }
        }

        private void inOrder(TreeNode root, List<Integer> list) {
            if (root != null) {
                inOrder(root.left, list);
                list.add(root.val);
                inOrder(root.right, list);
            }
        }

        public int[] findTwoSwapped(List<Integer> nums) {
            int n = nums.size();
            int x = -1, y = -1;
            for (int i = 0; i < n - 1; ++i) {
                if (nums.get(i + 1) < nums.get(i)) {
                    y = nums.get(i + 1);
                    if (x == -1) {
                        x = nums.get(i);
                    } else {
                        break;
                    }
                }
            }
            return new int[]{x, y};
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3, null, new TreeNode(2));
        new LeetCode99().new Solution().recoverTree(root);
    }
}
