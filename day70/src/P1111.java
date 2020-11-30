import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Zixiang Hu
 * @description P1111 修复公路
 * @create 2020-08-12-18:51
 */
public class P1111 {
    static class Edge {
        int start;
        int end;
        int distance;

        public Edge(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            edges.add(new Edge(a, b, c));
        }
        //按距离排序
        edges.sort(Comparator.comparingInt(e -> e.distance));
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (Edge edge : edges) {
            int a = find(edge.start, parent);
            int b = find(edge.end, parent);
            if (a != b) {
                parent[a] = b;
                n--;
                if (n == 1) {
                    System.out.println(edge.distance);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static int find(int x, int[] parent) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
}
