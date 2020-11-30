package com.learn.domain;

import com.learn.bean.ListNode;

/**
 * @author ZixiangHu
 * @create 2020-05-26  10:42
 * @description 环形链表
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head) {
        if (head==null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            if (fast.next == slow)
                return true;
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return false;
        }
        return false;
    }
}
