package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-07  17:20
 * @description LeetCode 572
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SubtreeOfAnotherTree {
    private boolean result;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            if (isSame(s, t))
                return true;
            else
                return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return s == null && t == null;
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s != null && t != null) {
            if (s.val != t.val)
                return false;
            else
                return isSame(s.left, t.left) && isSame(s.right, t.right);
        } else
            return s == null && t == null;
    }


    public static void main(String[] args) {

    }
}
