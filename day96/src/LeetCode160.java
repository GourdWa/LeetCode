/**
 * @author Zixiang Hu
 * @description 160. 相交链表
 * @create 2020-11-19-10:09
 */
public class LeetCode160 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int ALen = 0;
            int BLen = 0;
            ListNode pointA = headA, pointB = headB;
            while (pointA != null) {
                ALen++;
                pointA = pointA.next;
            }
            while (pointB != null) {
                BLen++;
                pointB = pointB.next;
            }
            pointA = headA;
            pointB = headB;
            while (ALen > BLen) {
                pointA = pointA.next;
                ALen--;
            }
            while (ALen < BLen) {
                pointB = pointB.next;
                BLen--;
            }
            while (pointA != null && pointB != null) {
                if (pointA == pointB)
                    return pointA;
                pointA = pointA.next;
                pointB = pointB.next;
            }
            return null;
        }
    }
}
