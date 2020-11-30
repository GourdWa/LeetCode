import java.util.HashSet;
import java.util.Set;

/**
 * @author Zixiang Hu
 * @description 面试题 02.01. 移除重复节点
 * @create 2020-06-26-18:04
 */
public class LeetCode02_01 {
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode fast = head.next;
            ListNode slow = head;
            boolean[] visited = new boolean[20000];
            visited[head.val] = true;
            while (fast != null) {
                if (!visited[fast.val]) {
                    slow.next = fast;
                    slow = slow.next;
                    visited[fast.val] = true;
                }
                fast = fast.next;
            }
            slow.next = null;
            return head;
        }
    }

}
