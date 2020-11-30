package com.learn.domain;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZixiangHu
 * @create 2020-05-13  20:03
 * @description LeetCode 102
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int t = 1, i;
        TreeNode pollNode;
        while (root != null && !queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (i = t, t = 0; i > 0; i--) {
                pollNode = queue.poll();
                list.add(pollNode.val);
                if (pollNode.left != null) {
                    t++;
                    queue.add(pollNode.left);
                }
                if (pollNode.right != null) {
                    t++;
                    queue.add(pollNode.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {

    }
}
