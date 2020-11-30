package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-10  21:22
 * @description 判断两颗二叉树是否相同
 */
public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val)
                return false;
            else
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else
            return p == null && q == null;
    }
}
