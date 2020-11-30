import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 207. 课程表
 * @create 2020-08-04-8:37
 */
public class LeetCode207 {
    class Solution {
        //BFS
/*        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //mat.get(i)也是一个List集合，其含义是：依赖i课程的课程，例如[1,2]，即1课程依赖2课程
            List<List<Integer>> mat = new ArrayList<>();
            //nums[i]的含义是课程i依赖的课程数量，比如2课程依赖1课程和3课程，那么nums[2]=2
            //我们应该先修没有依赖的课程，也就是nums[i]为0的课程
            int[] nums = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                mat.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                //修a课程之前需要先修b课程，也就是a课程依赖b课程
                int a = prerequisite[0], b = prerequisite[1];
                //依赖b的课程
                mat.get(b).add(a);
                //a依赖课程数量
                nums[a]++;
            }
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                //说明课程i没有依赖的课程
                if (nums[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                //学习pollCourse后将其从队列中弹出
                Integer pollCourse = queue.poll();
                //获得依赖pollCourse的课程的集合，因此此时pollCourse课程已经修了，因此将它们的依赖课程减1
                List<Integer> list = mat.get(pollCourse);
                if (list.size() > 0)
                    for (Integer ele : list) {
                        nums[ele]--;
                        //说明ele课程只依赖pollCourse，当后者学习完之后就可以学习ele课程，因此将其入队准备学习
                        if (nums[ele] == 0)
                            queue.add(ele);
                    }
            }
            for (int num : nums) {
                if (num != 0)
                    return false;
            }
            return true;
        }
        */
        //DFS
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //mat.get(i)也是一个List集合，其含义是：依赖i课程的课程，例如[1,2]，即1课程依赖2课程
            List<List<Integer>> mat = new ArrayList<>();
            int[] nums = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                mat.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                //修a课程之前需要先修b课程，也就是a课程依赖b课程
                int a = prerequisite[0], b = prerequisite[1];
                //依赖b的课程
                mat.get(b).add(a);
            }
            for (int i = 0; i < numCourses; i++) {
                if (dfs(i, nums, mat))
                    return false;
            }
            return true;
        }

        private boolean dfs(int i, int[] nums, List<List<Integer>> mat) {
            if (nums[i] == 1)
                return true;
            //证明已经学过了，可以不用管
            if (nums[i] == -1)
                return false;
            nums[i] = 1;
            List<Integer> list = mat.get(i);
            if (list.size() > 0)
                for (Integer ele : list) {
                    if (dfs(ele, nums, mat))
                        return true;
                }
            nums[i] = -1;
            return false;
        }
    }
}
