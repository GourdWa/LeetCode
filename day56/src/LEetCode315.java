import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 315. 计算右侧小于当前元素的个数
 * @create 2020-07-11-17:13
 */
public class LEetCode315 {
    class Solution {
        //暴力，超时
/*        public List<Integer> countSmaller(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int cnt = 0;
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] < num)
                        cnt++;
                }
                list.add(cnt);
            }

            return list;
        }*/
    }
}
