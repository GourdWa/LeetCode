import java.util.*;

/**
 * @author Zixiang Hu
 * @description 1207. 独一无二的出现次数
 * @create 2020-10-28-11:04
 */
public class LeetCode1207 {
    class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int ele : arr) {
                map.put(ele, map.getOrDefault(ele, 0) + 1);
            }
            List<Integer> list = new ArrayList<>();
            Iterator<Integer> iterator = map.values().iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            list.sort(Comparator.comparingInt(o -> o));
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) == list.get(i - 1))
                    return false;
            }
            return true;
        }
    }
}
