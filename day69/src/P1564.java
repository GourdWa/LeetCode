import java.util.*;

/**
 * @author Zixiang Hu
 * @description P1546 [USACO3.1]最短网络 Agri-Net
 * @create 2020-08-11-14:44
 */
public class P1564 {
    static class Edge {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }
    }


    /**
     * 假设从第0个农场开始铺设线路
     *
     * @param graph
     * @param n
     * @return
     */
    public static int prime(int[][] graph, int n) {
        int ans = 0;
        //如果lowerCost[i]为0，代表第i个节点已经加入了生成树
        int[] lowerCost = new int[n];
        //trace[k]=i，代表最小生成树从农场i向农场k生成
        int[] trace = new int[n];
        //刚开始时只有第一个农场加入了生成树
        for (int i = 1; i < n; i++) {
            lowerCost[i] = graph[0][i];
        }
        for (int i = 1; i < n; i++) {
            int k = -1;
            int minCost = Integer.MAX_VALUE;
            //找到未加入生成树，且距离最近的农场将其加入生成树
            for (int j = 0; j < n; j++) {
                if (lowerCost[j] != 0 && lowerCost[j] < minCost) {
                    minCost = lowerCost[j];
                    k = j;
                }
            }
            lowerCost[k] = 0;
            //从trace[k]向k生成，因此将距离加入ans
            ans += graph[trace[k]][k];
            for (int j = 0; j < n; j++) {
                //更新未加入生成树的节点的距离
                if (0 != lowerCost[j] && lowerCost[j] > graph[k][j]) {
                    lowerCost[j] = graph[k][j];
                    trace[j] = k;
                }
            }
        }
        return ans;
    }

    public static int kruskal(List<Edge> edges, int[] parent) {
        int ans = 0;
        for (Edge edge : edges) {
            int start = find(edge.start, parent);
            int end = find(edge.end, parent);
            if (start != end) {
                ans += edge.weight;
                parent[start] = end;
            }
        }
        return ans;
    }

    private static int find(int i, int[] parent) {
        while (parent[i] > 0)
            i = parent[i];
        return i;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入农场个数并保存
        int n = sc.nextInt();
        //输入每个农场之间的距离并保存在矩阵中
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        //用于克鲁斯卡尔算法
        List<Edge> edges = new ArrayList<>();
        int[] parent = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                edges.add(new Edge(j, i, graph[j][i]));
            }
        }
        edges.sort(Comparator.comparingInt(Edge::getWeight));
        System.out.println(kruskal(edges, parent));
//        System.out.println(prime(graph, n));
    }
}
