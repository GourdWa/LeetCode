import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 315. 计算右侧小于当前元素的个数
 * @create 2020-08-20-20:23
 */
public class LeetCode315 {
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int cnt = 0;
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] < nums[i])
                        cnt++;
                }
                list.add(cnt);
            }
            return list;
        }
    }
}
