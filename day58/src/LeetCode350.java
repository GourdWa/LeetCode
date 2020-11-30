import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zixiang Hu
 * @description 350. 两个数组的交集 II
 * @create 2020-07-13-18:36
 */
public class LeetCode350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int num : nums2) {
                if (map.containsKey(num) && map.get(num) > 0) {
                    list.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
