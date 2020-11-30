import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 785. 判断二分图
 * @create 2020-07-17-9:23
 */
public class LeetCode785 {
    /**
     * 因为只存在两个集合，将每个集合中的元素设置一个标记，1和-1
     * 相邻的两个节点肯定是不同的集合
     * 因此，从一个点开始遍历整个图，如果该点是1，其相邻的点是0，则将其领点设置为-1并将领点加入队列；如果相邻点是1，则返回false
     * 对于-1也是同样的操作
     * @param graph
     * @return
     */
    public static boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0)
                continue;
            visited[i] = 1;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int pollEle = queue.poll();
                int[] pollArr = graph[pollEle];
                for (int ele : pollArr) {
                    if (visited[ele] == 0)
                        queue.offer(ele);
                    if (visited[ele] == visited[pollEle])
                        return false;
                    if (visited[ele] == 0)
                        visited[ele] = -visited[pollEle];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        isBipartite(graph);


    }
}
