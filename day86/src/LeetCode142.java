/**
 * @author Zixiang Hu
 * @description 142. 环形链表 II
 * @create 2020-10-10-8:59
 */
public class LeetCode142 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null)
                return null;
            ListNode slow = head, fast = head.next.next;
            boolean hasCircle = false;
            while (slow != null && fast != null) {
                if (slow == fast) {
                    hasCircle = true;
                    break;
                }
                if (fast.next == null) {
                    hasCircle = false;
                    break;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            if (hasCircle) {
                int circleLength = 1;
                slow = slow.next;
                while (slow != fast) {
                    circleLength++;
                    slow = slow.next;
                }
                slow = head;
                fast = head;
                while (circleLength-- > 0)
                    fast = fast.next;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
            return null;
        }
    }
}
