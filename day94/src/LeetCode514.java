import java.util.*;

/**
 * @author Zixiang Hu
 * @description 514. 自由之路
 * @create 2020-11-11-11:05
 */
public class LeetCode514 {
    class Solution {
        public int findRotateSteps(String ring, String key) {
            Map<Character, List<Integer>> map = new HashMap<>();
            //定义一个记忆化数组
            int[][] memory = new int[ring.length()][key.length()];
            for (int[] memo : memory) {
                Arrays.fill(memo, -1);
            }
            for (int i = 0; i < ring.length(); i++) {
                char c = ring.charAt(i);
                if (map.containsKey(c)) {
                    List<Integer> list = map.get(c);
                    list.add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(c, list);
                }
            }
            return dfs(ring, key, map, memory, 0, 0) + key.length();
        }

        /**
         *
         * @param ring
         * @param key
         * @param map 存储ring中的字符的位置，键是ring中的字符，值是list
         * @param memory 记忆化数组
         * @param ringPos 当前12点指向的字符的位置
         * @param keyPos 当前匹配到的字符位置
         * @return
         */
        private int dfs(String ring, String key, Map<Character, List<Integer>> map, int[][] memory, int ringPos, int keyPos) {
            if (keyPos == key.length()) {
                return 0;
            }
            if (memory[ringPos][keyPos] != -1)
                return memory[ringPos][keyPos];
            char keyCh = key.charAt(keyPos);
            int res = Integer.MAX_VALUE;
            List<Integer> list = map.get(keyCh);
            //遍历可以转到的位置
            for (int i = 0; i < list.size(); i++) {
                //求出正转和反转的步数
                int step1 = Math.abs(ringPos - list.get(i));
                int step2 = ring.length() - Math.abs(ringPos - list.get(i));
                res = Math.min(res, Math.min(step1, step2) + dfs(ring, key, map, memory, list.get(i), keyPos + 1));
            }
            memory[ringPos][keyPos] = res;
            return res;
        }
    }

    public static void main(String[] args) {

    }
}
