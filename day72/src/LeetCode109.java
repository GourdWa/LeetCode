import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 109. 有序链表转换二叉搜索树
 * @create 2020-08-18-8:49
 */
public class LeetCode109 {
    class Solution {
        // 方法1 将链表数据转换为数组，然后根据搜索树的性质递归构建树
/*        public TreeNode sortedListToBST(ListNode head) {
            if (head == null)
                return null;
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            TreeNode root = new TreeNode(list.get(list.size() / 2));
            root.left = createTree(list, 0, list.size() / 2 - 1);
            root.right = createTree(list, list.size() / 2 + 1, list.size() - 1);
            return root;
        }

        private TreeNode createTree(List<Integer> list, int left, int right) {
            TreeNode node = null;
            if (right >= left) {
                int mid = left + (right - left) / 2;
                node = new TreeNode(list.get(mid));
                node.left = createTree(list, left, mid - 1);
                node.right = createTree(list, mid + 1, right);
            }
            return node;
        }*/
        // 利用快慢指针，快指针每次走两步，慢指针每次走一步。当快指针为空，或者快指针的下一个节点为空时，慢指针指向链表中间的节点
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null)
                return null;
            if (head.next == null)
                return new TreeNode(head.val);

            // 首先找到链表中间的节点
            ListNode slow = head, fast = head, pre = null;
            // 只需要考虑fast即可
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            pre.next = null;
            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(slow.next);
            return root;
        }
    }
}
