/**
 * @author Zixiang Hu
 * @description 19. 删除链表的倒数第N个节点
 * @create 2020-10-18-14:27
 */
public class LeetCode19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode first = head, second = head;
            while (n >= 0 && second != null) {
                second = second.next;
                n--;
            }
            //如果此时second已经为null，但是n还是大于等于0，说明删除的是第一个节点
            if (second == null && n >= 0)
                return head.next;
            while (second != null) {
                second = second.next;
                first = first.next;
            }
            //此时first指向待删除节点的前一个节点
            first.next = first.next.next;
            return head;
        }
    }
}
