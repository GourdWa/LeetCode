/**
 * @author Zixiang Hu
 * @description 25. K 个一组翻转链表
 * @create 2020-10-13-8:44
 */
public class LeetCode25 {
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1)
                return head;
            ListNode preNode = null;
            ListNode newHead = head;
            while (true) {
                int n = k - 1;
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new Solution().reverseKGroup(head, 2);
    }
}
