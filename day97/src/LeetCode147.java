/**
 * @author Zixiang Hu
 * @description 147. 对链表进行插入排序
 * @create 2020-11-21-13:21
 */
public class LeetCode147 {
    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null)
                return null;
            ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
            fakeHead.next = head;
            ListNode curNode = fakeHead, curNext = fakeHead.next;
            ListNode preNode = fakeHead;
            while (curNode != null && curNext != null) {
                if (curNode.val <= curNext.val) {
                    curNode = curNext;
                    curNext = curNext.next;
                } else {
                    //说明当前节点的值大于下一个节点的值，需要将下一个节点去除插入到前面去
                    curNode.next = curNext.next;
                    while (curNext.val >= preNode.val) {
                        if (curNext.val <= preNode.next.val) {
                            //找到了插入位置
                            curNext.next = preNode.next;
                            preNode.next = curNext;
                            preNode = fakeHead;
                            curNext = curNode.next;
                            break;
                        } else
                            preNode = preNode.next;
                    }
                }
            }
            return fakeHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-2147483647);
        head.next = new ListNode(-2147483648);
        new Solution().insertionSortList(head);
    }
}
