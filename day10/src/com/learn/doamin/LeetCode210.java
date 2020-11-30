package com.learn.doamin;

import java.util.*;

/**
 * @author ZixiangHu
 * @create 2020-05-17  10:48
 * @description
 */
public class LeetCode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        if (prerequisites.length)
        Map<Integer, List<Integer>> map = new HashMap<>();
        //存储每个课程的前导课程的数量
        int[] courseNum = new int[numCourses];
        Set<Integer> courseSet = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            courseSet.add(i);
        }
        for (int[] prerequisite : prerequisites) {
            //要学习firstCourse需要先学习secondCourse
            int firstCourse = prerequisite[0];
            int secondCourse = prerequisite[1];
//            courseSet.add(firstCourse);
//            courseSet.add(secondCourse);
            //如果包含，则更新后继课程
            if (map.containsKey(secondCourse)) {
                List<Integer> list = map.get(secondCourse);
                list.add(firstCourse);
                map.put(secondCourse, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(firstCourse);
                map.put(secondCourse, list);
            }
            courseNum[firstCourse]++;
        }
        Queue<Integer> preSet = new LinkedList<>();
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (courseNum[i]==0)
                preSet.add(i);
        }

        while (!preSet.isEmpty()) {
            Integer pollCorse = preSet.poll();
            courseSet.remove(pollCorse);
            tempList.add(pollCorse);
            List<Integer> list = map.get(pollCorse);
            if (list != null)
                for (Integer i : list) {
                    if (courseNum[i] == 1)
                        preSet.add(i);
                    else
                        courseNum[i] -= 1;
                }
        }
        if (courseSet.isEmpty()) {
            int[] res = new int[numCourses];
            for (int i = 0; i < tempList.size(); i++) {
                res[i] = tempList.get(i);
            }
            return res;
        } else return new int[]{};
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{};
        new LeetCode210().findOrder(2, ints);
    }
}
