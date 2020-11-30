package com.learn.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZixiangHu
 * @create 2020-05-10  9:59
 * @description 二叉树的最近公共祖先
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class LeetCode236 {
/*    private int cnt = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = root;
        while (ans != null) {
            cnt = 0;
            isCommonAncestor(ans, p, q);
            if (cnt == 2) {
                cnt = 0;
                isCommonAncestor(ans.left, p, q);
                if (cnt == 0) {
                    if (ans.val == p.val || ans.val == q.val)
                        break;
                    ans = ans.right;
                } else if (cnt == 1)
                    break;
                else
                    ans = ans.left;
            }
        }
        return ans;
    }

    private void isCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node != null && cnt < 2) {
            if (node.val == p.val || node.val == q.val)
                cnt++;
            isCommonAncestor(node.left, p, q);
            isCommonAncestor(node.right, p, q);
        }
    }*/


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode lChild = lowestCommonAncestor(root.left, p, q);
        TreeNode rChild = lowestCommonAncestor(root.right, p, q);
        if (lChild == null)
            return rChild;
        if (rChild == null)
            return lChild;
        return root;
    }


    public static void main(String[] args) {

    }
}
