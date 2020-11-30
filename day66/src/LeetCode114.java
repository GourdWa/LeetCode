/**
 * @author Zixiang Hu
 * @description 114. 二叉树展开为链表
 * @create 2020-08-02-9:40
 */
public class LeetCode114 {
    static class Solution {
        public void flatten(TreeNode root) {
            if (root != null) {
                TreeNode rightChild = root.right;
                TreeNode leftChild = root.left;
                flatten(leftChild);
                flatten(rightChild);
                //如果左孩子不为空，则将右孩子移动到左孩子的末端
                if (leftChild != null) {
                    TreeNode tempNode = leftChild;
                    //找到左孩子的末端
                    while (tempNode.right != null)
                        tempNode = tempNode.right;
                    //拼接上右孩子
                    tempNode.right = rightChild;
                    //将根节点的右子树赋值为左子树
                    root.right = leftChild;
                    //将左孩子置为null
                    root.left = null;
                } else
                    root.right = rightChild;
            }
        }

//        private void dfs(TreeNode root) {
//            if (root != null) {
//                TreeNode rightChild = root.right;
//                TreeNode leftChild = root.left;
//                dfs(leftChild);
//                dfs(rightChild);
//                //如果左孩子不为空，则将右孩子移动到左孩子的末端
//                if (leftChild != null) {
//                    TreeNode tempNode = leftChild;
//                    //找到左孩子的末端
//                    while (tempNode.right != null)
//                        tempNode = tempNode.right;
//                    //拼接上右孩子
//                    tempNode.right = rightChild;
//                    root.right = leftChild;
//                    //将左孩子置为null
//                    root.left = null;
//                } else
//                    root.right = rightChild;
//            }
//        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5, null, new TreeNode(6));
        new LeetCode114.Solution().flatten(root);
    }
}
