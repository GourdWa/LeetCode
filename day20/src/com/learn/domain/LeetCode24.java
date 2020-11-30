package com.learn.domain;

import com.learn.bean.ListNode;

/**
 * @author ZixiangHu
 * @create 2020-05-27  14:46
 * @description 24. 两两交换链表中的节点
 */
public class LeetCode24 {

    //直接两两交换
/*    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode new_head = new ListNode(0);
        ListNode res = new_head;

        new_head.next = head;
        while(head != null && head.next != null)
        {
            ListNode first_node = head;
            ListNode second_node = head.next;
            head.next = second_node.next;
            second_node.next = head;
            new_head.next = second_node;
            head = head.next;
            new_head = new_head.next.next;
        }
        return res.next;
    }*/


    public ListNode swapPairs(ListNode head) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode right = ans;
        int k;
        while (right != null) {
            ListNode left = right;
            for (k = 0; right.next != null && k < 2; k++)
                right = right.next;
            if (k != 2)
                break;
            ListNode temp = right.next;
            right.next = null;
            ListNode temp2 = left.next;
            left.next = swap(left.next);
            temp2.next = temp;
            right=temp2;
        }

        return ans.next;
    }

    public ListNode swap(ListNode head) {
        ListNode r = head.next;
        r.next = head;
        head.next = null;
        return r;
    }
}
