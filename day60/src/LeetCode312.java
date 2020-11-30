/**
 * @author Zixiang Hu
 * @description 312. 戳气球
 * @create 2020-07-19-17:21
 */
public class LeetCode312 {
//    使用记忆化进行优化
    public static int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        return helper(newNums, 0, newNums.length - 1);
    }

    private static int helper(int[] newNums, int start, int end) {
        int max = 0;
        for (int i = start + 1; i < end; i++) {
            max = Math.max(max,
                    newNums[i] * newNums[start] * newNums[end] +
                    helper(newNums, start, i) +
                    helper(newNums, i, end));
        }
        return max;
    }

    public static void main(String[] args) {
        maxCoins(new int[]{3, 2, 5, 8});
    }

}
