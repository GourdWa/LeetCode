import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Zixiang Hu
 * @description 486. 预测赢家
 * @create 2020-09-01-8:40
 */
public class LeetCode486 {
    static class Solution {
        public boolean PredictTheWinner(int[] nums) {
            return helper(nums, 0, 0, 0, nums.length - 1, true);
        }

        private boolean helper(int[] nums, int scoreA, int scoreB, int left, int right, boolean flagA) {
            //返回是否是A获胜
            if (left > right)
                return scoreA >= scoreB;
            if (flagA) { //如果是A选择，不管A选择左右那边，只要有一边能让A获胜即可
                return (helper(nums, scoreA + nums[left], scoreB, left + 1, right, false) ||
                        helper(nums, scoreA + nums[right], scoreB, left, right - 1, false));
            } else {//如果是B选择，不管B选择那边，只有两边都是A获胜，A才能真正获胜
                return (helper(nums, scoreA, scoreB + nums[left], left + 1, right, true) &&
                        helper(nums, scoreA, scoreB + nums[right], left, right - 1, true));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Random().nextInt();
        }
        long start = System.currentTimeMillis();
        System.out.println(new Solution().PredictTheWinner(nums));
        System.out.println(System.currentTimeMillis() - start);
    }
}
