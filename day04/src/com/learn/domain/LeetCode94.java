package com.learn.domain;

import java.util.*;

/**
 * @author ZixiangHu
 * @create 2020-05-10  21:16
 * @description 二叉树中序遍历 非递归实现
 */

public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode t = root;
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            TreeNode topNode = stack.pop();
            list.add(topNode.val);
            t = topNode.right;
        }
        return list;
    }
}
