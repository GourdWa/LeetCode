import java.util.*;

/**
 * @author Zixiang Hu
 * @description 347. 前 K 个高频元素
 * @create 2020-09-07-8:51
 */
public class LeetCode347 {


    static class Solution {
        static class Helper {
            int num;
            int cnt;

            public Helper(int num, int cnt) {
                this.num = num;
                this.cnt = cnt;
            }
        }

        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] res = new int[k];
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<Helper> list = new LinkedList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                list.add(new Helper(entry.getKey(), entry.getValue()));
            }
            Collections.sort(list, (o1, o2) -> o2.cnt - o1.cnt);
            for (int i = 0; i < k; i++) {
                res[i] = list.get(i).num;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        new Solution().topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2);
    }
}
