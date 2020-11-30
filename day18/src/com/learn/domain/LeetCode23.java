package com.learn.domain;

import com.learn.utils.ListNode;

/**
 * @author ZixiangHu
 * @create 2020-05-25  15:00
 * @description LeetCode 23 合并k个有序链表
 */

public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode head = new ListNode(-1);
        head.next = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ListNode t = head.next;
            head.next = merge(t, lists[i]);
        }
        return head.next;
    }

    private ListNode merge(ListNode t, ListNode list) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        while (t != null && list != null) {
            if (t.val < list.val) {
                temp.next = t;
                t = t.next;
            } else {
                temp.next = list;
                list = list.next;
            }
            temp = temp.next;
        }
        if (t != null) {
            temp.next = t;
        }
        if (list != null) {
            temp.next = list;
        }
        return ans.next;
    }
}
