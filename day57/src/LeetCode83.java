/**
 * @author Zixiang Hu
 * @description 83. 删除排序链表中的重复元素
 * @create 2020-07-12-20:21
 */
public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
