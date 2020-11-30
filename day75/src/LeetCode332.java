import java.util.*;

/**
 * @author Zixiang Hu
 * @description 332. 重新安排行程
 * @create 2020-08-27-8:52
 */
public class LeetCode332 {
    static class Solution {
        /*public List<String> findItinerary(List<List<String>> tickets) {
            List<String> res = new ArrayList<>();
            Map<String, ArrayList<String>> map = new HashMap<>();
            for (List<String> ticket : tickets) {
                String startPos = ticket.get(0);
                String endPos = ticket.get(1);
                if (!map.containsKey(startPos)) {
                    map.put(startPos, new ArrayList<>());
                }
                map.get(startPos).add(endPos);
            }
            map.forEach((k, v) -> {
                Collections.sort(v);
            });
            String curPos = "JFK";
            while (true) {
                res.add(curPos);
                ArrayList<String> list = map.get(curPos);
                if (list == null || list.size() == 0) {
                    map.remove(curPos);
                    if (map == null || map.size() == 0)
                        break;
                    else {
                        String temp = "zzzz";
                        for (String k : map.keySet()) {
                            if (k.compareTo(temp) < 0)
                                temp = k;
                        }
                        curPos = temp;
                        continue;
                    }
                }
                curPos = list.get(0);
                list.remove(0);
            }
            return res;
        }*/

        public List<String> findItinerary(List<List<String>> tickets) {
            List<String> list = new LinkedList<>();
            if (tickets == null || tickets.size() == 0)
                return list;
            //使用有限队列，会自动按字典序进行排序
            Map<String, PriorityQueue<String>> map = new HashMap<>();
            for (List<String> ticket : tickets) {
                PriorityQueue<String> priorityQueue = map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
                priorityQueue.add(ticket.get(1));
            }
            dfs("JFK", map, list);
            return list;
        }

        private void dfs(String dest, Map<String, PriorityQueue<String>> map, List<String> list) {
            PriorityQueue<String> priorityQueue = map.get(dest);
            while (priorityQueue != null && priorityQueue.size() > 0) {
                String pollEle = priorityQueue.poll();
                dfs(pollEle, map, list);
            }
            list.add(0, dest);
        }
    }

    public static void main(String[] args) {
//        [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("JFK", "KUL"));
        tickets.add(Arrays.asList("JFK", "NRT"));
        tickets.add(Arrays.asList("NRT", "JFK"));
        System.out.println(new Solution().findItinerary(tickets));

    }
}
