/**
 * @author Zixiang Hu
 * @description 24. 两两交换链表中的节点
 * @create 2020-10-13-9:15
 */
public class LeetCode24 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null)
                return head;
            ListNode preNode = null;
            ListNode newHead = head;
            while (true) {
                int n = 1;
                ListNode curNode = head;
                while (head != null && n-- > 0) {
                    head = head.next;
                }
                if (n != -1)
                    break;
                ListNode nextNode = head.next;
                head.next = null;
                if (preNode != null)
                    preNode.next = reverse(curNode);
                else
                    newHead = reverse(curNode);
                preNode = curNode;
                preNode.next = nextNode;
                head = nextNode;
            }
            return newHead;
        }
        private ListNode reverse(ListNode head) {
            ListNode preNode = null;
            ListNode curNode = head;
            while (curNode != null) {
                ListNode temp = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = temp;
            }
            return preNode;
        }
    }
}
