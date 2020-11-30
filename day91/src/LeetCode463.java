import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 463. 岛屿的周长
 * @create 2020-10-30-11:20
 */
public class LeetCode463 {
    static class Solution {
        public int islandPerimeter(int[][] grid) {
            int ans = 0;
            int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        for (int[] dir : dirs) {
                            int x = dir[0] + i;
                            int y = dir[1] + j;
                            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
                                ans++;
                            else if (grid[x][y] == 0)
                                ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]
                {{0}, {1}};
        System.out.println(new Solution().islandPerimeter(arr));
    }
}
