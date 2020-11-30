import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zixiang Hu
 * @description 洛谷P1744
 * @create 2020-08-10-10:24
 */
public class P1744 {
    static class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static double[] dijksra(double[][] graph, int start) {
        //distance[i]代表第i个节点到start节点的距离
        double[] distance = new double[graph.length];
        Arrays.fill(distance, Double.MAX_VALUE);
        for (int i = 0; i < distance.length; i++) {
            distance[i] = graph[start][i];
        }
        boolean[] visited = new boolean[graph.length];
        visited[start] = true;
        int cnt = 0;
        //每次找出最近的节点并加入visited
        while (cnt < graph.length - 1) {
            int k = 0;
            double miniDis = Double.MAX_VALUE;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i] && distance[i] < miniDis) {
                    k = i;
                    miniDis = distance[i];
                }
            }
            cnt++;
            visited[k] = true;
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i] && graph[k][i] != Double.MAX_VALUE && distance[i] > distance[k] + graph[k][i]) {
                    distance[i] = distance[k] + graph[k][i];
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //店铺的数量
        int n = sc.nextInt();
        double[][] graph = new double[n][n];
        //position.get(i)代表第i家店铺的位置
        List<Pos> position = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Double.MAX_VALUE);
            graph[i][i] = 0;
            int x = sc.nextInt();
            int y = sc.nextInt();
            position.add(new Pos(x, y));
        }
        int m = sc.nextInt();
        //输入那两家店铺是连通的
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            //获得这两家店的坐标并计算距离
            Pos first = position.get(a);
            Pos second = position.get(b);
            double dis = Math.sqrt((first.x - second.x) * (first.x - second.x) + (first.y - second.y) * (first.y - second.y));
            graph[a][b] = dis;
            graph[b][a] = dis;
        }
        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;
        double[] distance = dijksra(graph, start);
        System.out.printf("%.2f",distance[end]);
    }
}
