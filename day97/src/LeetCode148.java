import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Zixiang Hu
 * @description 148. 排序链表
 * @create 2020-11-21-13:55
 */
public class LeetCode148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
            while (head != null) {
                heap.offer(head);
                head = head.next;
            }
            ListNode fakeHead = new ListNode(0);
            ListNode curHead = fakeHead;
            while (!heap.isEmpty()) {
                curHead.next = heap.poll();
                curHead = curHead.next;
            }
            curHead.next = null;
            return fakeHead.next;
        }
    }
}
