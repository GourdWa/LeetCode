
/**
 * @author Zixiang Hu
 * @description 141. 环形链表
 * @create 2020-10-09-8:45
 */
public class LeetCode141 {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null)
                return false;
            ListNode fast = head.next.next, slow = head.next;
            while (fast != null && slow != null) {
                if (fast == slow)
                    return true;
                if (fast.next == null)
                    return false;
                fast = fast.next.next;
                slow = slow.next;
            }
            return false;
        }
    }
}
