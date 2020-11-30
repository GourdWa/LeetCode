/**
 * @author Zixiang Hu
 * @description 1300. 转变数组后最接近目标值的数组和
 * @create 2020-06-14-14:57
 */
public class LeetCode1300 {
    public int findBestValue(int[] arr, int target) {
        int ans = target;
        int sum;
        int diff = Integer.MAX_VALUE;
        for (int i = target / arr.length; i < target; i++) {
            sum = 0;
            for (int ele : arr) {
                if (ele > i)
                    sum += i;
                else
                    sum += ele;
            }
            if (Math.abs(sum - target) < diff) {
                diff = Math.abs(sum - target);
                ans = i;
            }else
                break;
        }
        return ans;
    }
}
