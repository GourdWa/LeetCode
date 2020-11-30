import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Zixiang Hu
 * @description 632. 最小区间
 * @create 2020-08-01-15:25
 */
public class LeetCode632 {
    class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            int n = nums.size();
            int inf = 0x3f3f3f;
            int max = -inf; // 当前最大值
            int st = -inf;  // 起点
            int ed = inf;   // 终点

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

            // 相当于合并k个有序链表，把 head 放进去
            //把每个列表的第0个位置的元素放入优先队列
            for (int i = 0; i < n; i++) {
                int val = nums.get(i).get(0);
                pq.offer(new Node(i, 0, val));
                max = Math.max(max, val);
            }

            // 必须包含 k 个元素
            while (pq.size() == n) {
                //poll出最小的val
                Node node = pq.poll();
                //队列编号
                int i = node.i;
                //队列中的位置
                int j = node.j;
                int val = node.val;

                // 更新区间长度
                if (max - val < ed - st) {
                    st = val;
                    ed = max;
                }

                // 为堆中填充元素
                //从移除的那个队列中添加一个元素进来
                if (j + 1 < nums.get(i).size()) {
                    int nVal = nums.get(i).get(j + 1);
                    pq.offer(new Node(i, j + 1, nVal));
                    max = Math.max(max, nVal);
                }
            }
            return new int[]{st, ed};

        }

        class Node{
            int i, j, val;

            public Node(int i, int j, int val) {
                this.i = i;//第几个队列
                this.j = j;//元素编号
                this.val = val;//元素的值
            }
        }
    }
}
