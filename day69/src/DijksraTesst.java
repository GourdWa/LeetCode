import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description
 * @create 2020-08-10-10:07
 */
public class DijksraTesst {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 5, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY},
                {1, 0, 3, 7, 5, INFINITY, INFINITY, INFINITY, INFINITY},
                {5, 3, 0, INFINITY, 1, 7, INFINITY, INFINITY, INFINITY},
                {INFINITY, 7, INFINITY, 0, 2, INFINITY, 3, INFINITY, INFINITY},
                {INFINITY, 5, 1, 2, 0, 3, 6, 9, INFINITY},
                {INFINITY, INFINITY, 7, INFINITY, 3, 0, INFINITY, 5, INFINITY},
                {INFINITY, INFINITY, INFINITY, 3, 6, INFINITY, 0, 2, 7},
                {INFINITY, INFINITY, INFINITY, INFINITY, 9, 5, 2, 0, 4},
                {INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, INFINITY, 7, 4, 0}
        };
        int[] distance = dijksra(graph, 0);
        System.out.println(Arrays.toString(distance));
    }

    private static int[] dijksra(int[][] graph, int start) {
        //distance数组中存储了从起始顶点出发到每个顶点的距离
        int[] distance = new int[graph.length];
        //当到达i顶点时，visited[i]设置为true
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;
        int[] trace = new int[graph.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = graph[start][i];
        }

        int cnt = 0;
        while (cnt < distance.length - 1) {
            int k = 0;
            int min = Integer.MAX_VALUE;
            //找到当前未到达的节点中距离最近的节点
            for (int i = 0; i < distance.length; i++) {
                if (!visited[i] && distance[i] < min) {
                    k = i;
                    min = distance[i];
                }
            }
            cnt++;
            visited[k] = true;
            for (int i = 0; i < distance.length; i++) {
                //如果顶点i未被访问过，从k顶点能够到达i顶点
                // 并且从起始点到顶点i的距离大于懂起始点经顶点k再到i的距离，更新最短距离
                if (!visited[i] && graph[k][i] != Integer.MAX_VALUE && distance[i] > distance[k] + graph[k][i]) {
                    trace[i] = k;
                    distance[i] = distance[k] + graph[k][i];
                }
            }
        }

        System.out.println(Arrays.toString(trace));
        return distance;
    }
}
