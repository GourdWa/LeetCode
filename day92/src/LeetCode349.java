import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zixiang Hu
 * @description 349. 两个数组的交集
 * @create 2020-11-02-18:39
 */
public class LeetCode349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int ele : nums1) {
                set.add(ele);
            }
            for (int ele : nums2) {
                if (set.contains(ele) && !list.contains(ele))
                    list.add(ele);
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
