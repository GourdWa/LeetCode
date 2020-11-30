package com.learn.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-22  13:01
 * @description
 */
public class LeetCode106 {
    int count = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0)
            return null;
        count = postorder.length - 1;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        root.right = createTree(map.get(postorder[postorder.length - 1]) + 1, postorder.length, map, inorder, postorder);
        root.left = createTree(0, map.get(postorder[postorder.length - 1]), map, inorder, postorder);
        return root;
    }

    private TreeNode createTree(int left, int right, Map<Integer, Integer> map, int[] inorder, int[] postorder) {
        if (left >= right || count <= 0)
            return null;
        count--;
        int i = count;

        TreeNode root = new TreeNode(postorder[count]);
        root.right = createTree(map.get(postorder[i]) + 1, right, map, inorder, postorder);
        root.left = createTree(left, map.get(postorder[i]), map, inorder, postorder);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        new LeetCode106().buildTree(inorder, postorder);
    }
}
