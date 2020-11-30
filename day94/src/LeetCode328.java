/**
 * @author Zixiang Hu
 * @description 328. 奇偶链表
 * @create 2020-11-13-8:44
 */
public class LeetCode328 {
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            int i = 0;
            ListNode oddHead = head, evenHead = head.next;
            ListNode oddTemp = oddHead, evenTemp = evenHead, point = head.next.next;
            while (point != null) {
                i += 1;
                if (i % 2 == 1) {
                    oddTemp.next = point;
                    oddTemp = oddTemp.next;
                } else {
                    evenTemp.next = point;
                    evenTemp = evenTemp.next;
                }
                point = point.next;
            }
            evenTemp.next = null;
            oddTemp.next = evenHead;
            return oddHead;
        }
    }
}
