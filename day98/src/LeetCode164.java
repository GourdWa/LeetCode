import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Zixiang Hu
 * @description 164. 最大间距
 * @create 2020-11-26-9:08
 */
public class LeetCode164 {
    static class Solution {
     /*   public int maximumGap(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 1; i <= nums.length - 1; i++) {
                ans = nums[i] - nums[i - 1] > ans ? nums[i] - nums[i - 1] : ans;
            }
            return ans;
        }*/

        //桶排序实现，爆内存
        public int maximumGap(int[] nums) {
            if (nums == null || nums.length < 2)
                return 0;
            int ans = 0;
            int minVal = Arrays.stream(nums).min().getAsInt();
            int maxVal = Arrays.stream(nums).max().getAsInt();
            //定义桶数量
            int bucketNum = (maxVal - minVal) / nums.length + 1;
            ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
            for (int i = 0; i < bucketNum; i++) {
                buckets.add(new ArrayList<>());
            }
            for (int num : nums) {
                int no = (num - minVal) / nums.length;
                buckets.get(no).add(num);
            }
            buckets.forEach(bucket -> Collections.sort(bucket));
            int index = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer ele : bucket) {
                    nums[index++] = ele;
                }
            }
            for (int i = 1; i <= nums.length - 1; i++) {
                ans = nums[i] - nums[i - 1] > ans ? nums[i] - nums[i - 1] : ans;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new Solution().maximumGap(new int[]{1, 1000});
    }
}
