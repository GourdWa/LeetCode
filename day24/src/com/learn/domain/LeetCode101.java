package com.learn.domain;

import com.learn.bean.TreeNode;

/**
 * @author ZixiangHu
 * @create 2020-05-31  10:36
 * @description
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode lNode, TreeNode rNode) {
        if (lNode != null && rNode != null) {
            if (lNode.val != rNode.val)
                return false;
            return symmetric(lNode.left, rNode.right) && symmetric(lNode.right, rNode.left);
        }
        return lNode == null && rNode == null;
    }
}
