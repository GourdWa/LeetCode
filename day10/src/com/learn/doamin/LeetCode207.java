package com.learn.doamin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-17  20:04
 * @description
 */
public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] flag = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, flag))
                return false;
        }
        return true;
    }

    private boolean dfs(int i, Map<Integer, List<Integer>> map, int[] flag) {
        if (flag[i] == -1)
            return true;
        if (flag[i] == 1)
            return false;
        flag[i] = 1;
        for (Integer integer : map.get(i)) {
            if (!dfs(integer, map, flag))
                return false;
        }
        flag[i] = -1;
        return true;
    }


    public static void main(String[] args) {
        int[][] ints = new int[][]{{1, 0}, {0, 1}};
        new LeetCode207().canFinish(2, ints);
    }
}
