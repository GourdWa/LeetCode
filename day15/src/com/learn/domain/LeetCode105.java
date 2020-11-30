package com.learn.domain;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-22  10:25
 * @description
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LeetCode105 {
    int count = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        root.left = createTree(0, map.get(preorder[0]), map, preorder, inorder);
        root.right = createTree(map.get(preorder[0]) + 1, preorder.length, map, preorder, inorder);

        return root;
    }

    private TreeNode createTree(int left, int right, Map<Integer, Integer> map, int[] preorder, int[] inorder) {
        if (left >= right) {
            return null;
        }
        count++;
        int i = count;
        //构建根节点
        TreeNode root = new TreeNode(preorder[count]);
        root.left = createTree(left, map.get(preorder[i]), map, preorder, inorder);
        root.right = createTree(map.get(preorder[i]) + 1, right, map, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6};
        int[] inorder = new int[]{4, 2, 5, 1, 6, 3};
        new LeetCode105().buildTree(preorder, inorder);
    }
}
