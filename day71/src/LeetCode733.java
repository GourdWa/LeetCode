import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 733. 图像渲染
 * @create 2020-08-16-9:53
 */
public class LeetCode733 {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Solution {
        //BFS
       /* public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

            boolean[][] visited = new boolean[image.length][image[0].length];
            int val = image[sr][sc];
            Queue<Pos> queue = new LinkedList<>();
            queue.add(new Pos(sr, sc));
            while (!queue.isEmpty()) {
                Pos pollEle = queue.poll();
                visited[pollEle.x][pollEle.y] = true;
                image[pollEle.x][pollEle.y] = newColor;
                for (int[] ele : dir) {
                    int xx = ele[0] + pollEle.x;
                    int yy = ele[1] + pollEle.y;
                    if (xx >= 0 && xx < image.length && yy >= 0 && yy < image[0].length && !visited[xx][yy] && image[xx][yy] == val) {
                        queue.add(new Pos(xx, yy));
                    }
                }
            }
            return image;
        }*/
        //DFS
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            boolean[][] visited = new boolean[image.length][image[0].length];
            dfs(image, sr, sc, newColor, visited, image[sr][sc]);
            return image;
        }

        private void dfs(int[][] image, int sr, int sc, int newColor, boolean[][] visited, int val) {
            visited[sr][sc] = true;
            image[sr][sc] = newColor;
            for (int[] ele : dir) {
                int xx = ele[0] + sr;
                int yy = ele[1] + sc;
                if (xx >= 0 && xx < image.length && yy >= 0 && yy < image[0].length && !visited[xx][yy] && image[xx][yy] == val) {
                    dfs(image, xx, yy, newColor, visited, val);
                }
            }
        }
    }
}
