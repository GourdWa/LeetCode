/**
 * @author Zixiang Hu
 * @description 2. 两数相加
 * @create 2020-10-04-9:04
 */
public class LeetCode2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode newHead = new ListNode(-1);
            ListNode point = newHead;
            while (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                point.next = new ListNode(sum % 10);
                carry = sum / 10;

                l1 = l1.next;
                l2 = l2.next;
                point = point.next;
            }
            while (l1 != null) {
                int sum = l1.val + carry;
                point.next = new ListNode(sum % 10);
                carry = sum / 10;

                l1 = l1.next;
                point = point.next;
            }
            while (l2 != null) {
                int sum = l2.val + carry;
                point.next = new ListNode(sum % 10);
                carry = sum / 10;

                l2 = l2.next;
                point = point.next;
            }
            if (carry == 1)
                point.next = new ListNode(1);
            return newHead.next;
        }
    }
}
