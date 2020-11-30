package com.learn.domain;

import com.learn.bean.ListNode;

/**
 * @author ZixiangHu
 * @create 2020-05-28  17:52
 * @description 25. K 个一组翻转链表
 */
public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode(0);
        ans.next = head;
        ListNode left;
        ListNode right = ans;
        int i;
        while (right != null) {
            left = right;
            for (i = 0; right.next != null && i < k; i++) {
                right = right.next;
            }
            if (i < k)
                break;
            ListNode temp = right.next;
            ListNode temp2 = left.next;
            right.next = null;
            left.next = reverse(left.next);
            temp2.next = temp;
            right=temp2;
        }
        return ans.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
