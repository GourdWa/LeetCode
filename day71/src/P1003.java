import java.util.Scanner;

/**
 * @author Zixiang Hu
 * @description P1003 铺地毯
 * @create 2020-08-14-14:08
 */
public class P1003 {
    static class Node {
        private int a;
        private int b;
        private int c;
        private int d;

        public Node(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            Node node = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            nodes[i] = node;
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        for (int i = n; i > 0; i--) {
            if (x >= nodes[i].a && x <= nodes[i].a + nodes[i].c && y >= nodes[i].b && y <= nodes[i].b + nodes[i].d) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
