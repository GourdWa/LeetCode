import java.util.*;

/**
 * @author Zixiang Hu
 * @description 841. 钥匙和房间
 * @create 2020-08-31-8:50
 */
public class LeetCode841 {
    static class Solution {
        // BFS
   /*     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null || rooms.size() == 0)
                return true;
            boolean[] visited = new boolean[rooms.size()];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            while (!queue.isEmpty()) {
                Integer pollEle = queue.poll();
                visited[pollEle] = true;
                List<Integer> list = rooms.get(pollEle);
                if (list != null && list.size() > 0) {
                    for (Integer key : list) {
                        if (!visited[key] && key != pollEle) {
                            queue.add(key);
                        }
                    }
                }
            }
            for (boolean b : visited) {
                if (!b)
                    return false;
            }
            return true;
        }*/
        // DFS
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null || rooms.size() == 0)
                return true;
            boolean[] visited = new boolean[rooms.size()];
            dfs(0, visited, rooms);
            for (boolean b : visited) {
                if (!b)
                    return false;
            }
            return true;
        }

        private void dfs(int num, boolean[] visited, List<List<Integer>> rooms) {
            visited[num] = true;
            List<Integer> room = rooms.get(num);
            if (room != null && room.size() > 0) {
                for (Integer key : room) {
                    if (key != num && !visited[key])
                        dfs(key, visited, rooms);
                }
            }
        }
    }

    public static void main(String[] args) {
//        [[4],[3],[],[2,5,7],[1],[],[8,9],[],[],[6]]
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(1));
        lists.add(Arrays.asList(2));
        lists.add(Arrays.asList(3));
        lists.add(Arrays.asList());
        System.out.println(new Solution().canVisitAllRooms(lists));

    }
}
