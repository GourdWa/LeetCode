import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 117. 填充每个节点的下一个右侧节点指针 II
 * @create 2020-09-28-8:51
 */
public class LeetCode117 {
    class Solution {
        // 利用层级遍历实现，空间复杂度为O(n)
        /*   public Node connect(Node root) {
               Queue<Node> queue = new LinkedList<>();
               Node node = root;
               if (node != null)
                   queue.add(node);
               while (!queue.isEmpty()) {
                   int size = queue.size();
                   while (size-- > 0) {
                       Node pollNode = queue.poll();
                       if (size > 0)
                           pollNode.next = queue.peek();
                       if (pollNode.left != null)
                           queue.add(pollNode.left);
                       if (pollNode.right != null)
                           queue.add(pollNode.right);
                   }
               }
               return root;
           }*/
        // 利用链表的思想实现，空间复杂度为O(1)
        public Node connect(Node root) {
            if (root == null)
                return null;
            Node cur = root;
            while (cur != null) {
                Node head = new Node();
                Node point = head;
                while (cur != null) {
                    if (cur.left != null) {
                        point.next = cur.left;
                        point = point.next;
                    }
                    if (cur.right != null) {
                        point.next = cur.right;
                        point = point.next;
                    }
                    cur = cur.next;
                }
                cur = head.next;
            }
            return root;
        }
    }

    public static void main(String[] args) {

    }
}
