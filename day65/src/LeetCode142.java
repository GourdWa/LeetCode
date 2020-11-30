/**
 * @author Zixiang Hu
 * @description 142. 环形链表 II
 * @create 2020-07-31-19:02
 */
public class LeetCode142 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null)
                return null;
            ListNode slow = head, fast = head.next;
            boolean hasCircle = false;
            while (slow != null && fast != null) {
                if (slow == fast) {
                    hasCircle = true;
                    break;
                }
                slow = slow.next;
                //快指针每次移动两步
                if (fast.next != null)
                    fast = fast.next.next;
                else
                    break;
            }
            //如果链表中存在环，则求出环的中节点的个数
            if (hasCircle) {
                int nodeCnt = 1;
                slow = slow.next;
                //计算环中节点的个数
                while (slow != fast) {
                    nodeCnt++;
                    slow = slow.next;
                }
                fast = head;
                slow = head;
                while (nodeCnt-- > 0) {
                    fast = fast.next;
                }
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
