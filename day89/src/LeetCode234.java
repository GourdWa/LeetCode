import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Zixiang Hu
 * @description 234. 回文链表
 * @create 2020-10-23-8:49
 */
public class LeetCode234 {
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null)
                return true;
            int len = 0;
            ListNode point = head;
            Deque<ListNode> stack = new LinkedList<>();
            //求出链表的长度
            while (point != null) {
                len++;
                point = point.next;
            }int k;
            if (len % 2 == 0) {
                k = len / 2;
            } else {
                 k  = len / 2 + 1;
            }
            point = head;
            //使point指向中间的节点
            while (k-- > 0) {
                stack.push(point);
                point = point.next;
            }
            if (len % 2 != 0)
                stack.pop();
            while (point != null) {
                ListNode popEle = stack.pop();
                if (point.val != popEle.val)
                    return false;
                point = point.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
//        node.next.next.next.next = new ListNode(1);
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(node));
    }
}
