package com.learn.domain;

import com.learn.bean.ListNode;

/**
 * @author ZixiangHu
 * @create 2020-05-21  10:24
 * @description 删除倒数第n个节点
 */
public class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans = new ListNode(-1);
        ans.next = head;
        ListNode left = ans;
        ListNode right = ans;
        while (n > 0) {
            right = right.next;
            n -= 1;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return ans.next;
    }
}
