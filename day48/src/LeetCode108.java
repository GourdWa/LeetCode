/**
 * @author Zixiang Hu
 * @description 108. 将有序数组转换为二叉搜索树
 * @create 2020-07-03-10:49
 */
public class LeetCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int len = nums.length;
        TreeNode root = new TreeNode(nums[len / 2]);
        root.left = createTree(nums, 0, len / 2 - 1);
        root.right = createTree(nums, len / 2 + 1, len - 1);
        return root;
    }

    private TreeNode createTree(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = createTree(nums, left, mid - 1);
            node.right = createTree(nums, mid + 1, right);
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        new LeetCode108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
