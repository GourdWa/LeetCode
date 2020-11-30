/**
 * @author Zixiang Hu
 * @description 116. 填充每个节点的下一个右侧节点指针
 * @create 2020-10-15-8:46
 */
public class LeetCode116 {
    static class Solution {
        public Node connect(Node root) {
            Node first = root;
            while (first != null) {
                Node second = new Node();
                Node temp = second;
                while (first != null) {
                    //因为是完全二叉树，因此，只要左节点不为空，右节点一定不为空
                    //如果这里不是完全二叉树，则需要先判断左节点再判断右节点。也就是117题
                    if (first.left != null) {
                        temp.next = first.left;
                        temp = temp.next;
                        temp.next = first.right;
                        temp = temp.next;
                    }
                    first = first.next;
                }
                first = second.next;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        new Solution().connect(node);
    }
}
