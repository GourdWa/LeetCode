/**
 * @author Zixiang Hu
 * @description 2. 两数相加
 * @create 2020-06-14-21:06
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode point = ans;
        boolean carry = false;
        int sum = 0;
        while (l1 != null && l2 != null) {
            if (carry) {
                carry = false;
                sum = l1.val + l2.val + 1;
            } else
                sum = l1.val + l2.val;
            carry = sum >= 10;
            point.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        while (l1 != null) {
            if (carry) {
                carry = false;
                sum = l1.val + 1;
            } else
                sum = l1.val;
            carry = sum >= 10;
            point.next = new ListNode(sum % 10);
            point = point.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            if (carry) {
                carry = false;
                sum = l2.val + 1;
            } else
                sum = l1.val;
            carry = sum >= 10;
            point.next = new ListNode(sum % 10);
            point = point.next;
            l2 = l2.next;
        }
        if (carry)
            point.next = new ListNode(0);
        return ans.next;
    }
}
