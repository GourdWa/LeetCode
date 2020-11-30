/**
 * @author Zixiang Hu
 * @description 657. 机器人能否返回原点
 * @create 2020-08-28-8:53
 */
public class LeetCode657 {
    class Solution {
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        public boolean judgeCircle(String moves) {
            if (moves == null || moves.length() == 0)
                return true;
            int[] pos = new int[]{0, 0};
            for (int i = 0; i < moves.length(); i++) {
                if (moves.charAt(i) == 'U') {
                    pos[0] += dir[0][0];
                    pos[1] += dir[0][1];
                } else if (moves.charAt(i) == 'D') {
                    pos[0] += dir[1][0];
                    pos[1] += dir[1][1];
                } else if (moves.charAt(i) == 'L') {
                    pos[0] += dir[2][0];
                    pos[1] += dir[2][1];
                } else if (moves.charAt(i) == 'R') {
                    pos[0] += dir[3][0];
                    pos[1] += dir[3][1];
                }
            }
            return pos[0] == 0 && pos[1] == 0;
        }
    }
}
