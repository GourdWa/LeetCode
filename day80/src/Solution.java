import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description
 * @create 2020-09-10-16:44
 */
public class Solution {
    public static int[] helper(double[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            if (i > 0 && arr[i] >= arr[i - 1]) {
                j = i - 1 + ans[i - 1];
            }
            for (; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = helper(new double[]{36.8, 36.3, 36.4, 36.5, 37, 39, 39.5, 38, 37, 36.5, 37});
        System.out.println(Arrays.toString(ints));
    }
}
