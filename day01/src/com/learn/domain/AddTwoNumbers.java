package com.learn.domain;


/**
 * @author ZixiangHu
 * @create 2020-05-06  18:43
 * @description LeetCode 2
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode head = new ListNode(-1);
        ListNode point = head;
        int sum = 0;
        while (l1 != null && l2 != null) {
            if (carry)
                sum = 1 + l1.val + l2.val;
            else
                sum = l1.val + l2.val;
            carry = sum < 10 ? false : true;
            point.next = new ListNode(sum % 10);
            point = point.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null && carry)
            point.next = new ListNode(1);

        while (l1 != null) {
            if (carry)
                sum = 1 + l1.val;
            else
                sum = l1.val;
            carry = sum < 10 ? false : true;
            point.next = new ListNode(sum % 10);
            point = point.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            if (carry)
                sum = 1 + l2.val;
            else
                sum = l2.val;
            carry = sum < 10 ? false : true;
            point.next = new ListNode(sum % 10);
            point = point.next;
            l2 = l2.next;
        }
        if (carry)
            point.next = new ListNode(1);
        return head.next;
    }

    public static void main(String[] args) {

    }
}
