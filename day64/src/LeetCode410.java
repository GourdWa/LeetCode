/**
 * @author Zixiang Hu
 * @description 410. 分割数组的最大值
 * @create 2020-07-25-19:08
 */
public class LeetCode410 {
    static class Solution {
        //动态规划
/*        public int splitArray(int[] nums, int m) {
            int n = nums.length;
            //存储前缀和
            int[] sub = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sub[i + 1] = nums[i] + sub[i];
            }
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                //将前i个数分为1组
                dp[i][1] = sub[i];
                //将前i个数分为j组
                for (int j = 2; j <= m && j <= i; j++) {
                    //将前k个数分为j-1组，[k+1,i]之间的数分为一组
                    for (int k = 1; k < i; k++) {
                        int diff = sub[i] - sub[k];
                        //因为给定的是整数数组，所以按道理dp[i][j]除了初始化为0，其他时候如果用过了dp[i][j]，那么必然不为0
                        if (dp[i][j] != 0)
                            dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], diff));
                        else
                            dp[i][j] = Math.max(dp[k][j - 1], diff);
                    }
                }
            }
            return dp[n][m];
        }*/
        //二分查找
        public int splitArray(int[] nums, int m) {
            int low = nums[0], high = 0;
            for (int num : nums) {
                high += num;
                low = low > num ? low : num;
            }
            int mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                //因为至少有一个和是符合要求的
                int cnt = 1;
                int temp = 0;
                for (int num : nums) {
                    temp += num;
                    //必须要个大于mid
                    if (temp > mid) {
                        cnt++;
                        temp = num;
                    }
                }
                if (cnt > m)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return low;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}
