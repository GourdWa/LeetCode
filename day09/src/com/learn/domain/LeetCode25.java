package com.learn.domain;

import com.learn.bean.ListNode;

/**
 * @author ZixiangHu
 * @create 2020-05-16  13:25
 * @description
 */

public class LeetCode25 {
    //递归方式
/*    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current_node = head;
        int count = 0;
        while (current_node != null && count != k) {
            current_node = current_node.next;
            count++;
        }
        if (count == k) {
            current_node = reverseKGroup(current_node, k);/// 递归的解决子问题
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = current_node;
                current_node = head;
                head = temp;
            }///最终，该段的所有节点将会截空，head应指向current_node
            head = current_node;
        }
        return head;
    }*/
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(-1);
        ans.next = head;
        int cnt;
        ListNode right = ans;
        ListNode left = ans;
        while (right != null) {
            cnt = 0;
            ListNode start = right.next;
            while (right != null && cnt++ < k)
                right = right.next;
            if (cnt < k || right == null)
                break;
            ListNode temp = right.next;
            right.next = null;
            left.next = reverse(start);
            start.next = temp;
            left = start;
            right = start;
        }
        return ans.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode cur = start;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next.next = new ListNode(6);
        new LeetCode25().reverseKGroup(head, 2);
    }
}
