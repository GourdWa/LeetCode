import java.util.Arrays;

/**
 * @author Zixiang Hu
 * @description 922. 按奇偶排序数组 II
 * @create 2020-11-12-9:46
 */
public class LeetCode922 {
    static class Solution {

        /* public int[] sortArrayByParityII(int[] A) {
             int i = 0;
             while (i < A.length) {
                 int j = i;
                 boolean isOdd = false;
                 while (j < A.length) {
                     if (j % 2 != A[j] % 2) {
                         //j是奇数，则A[j]是偶数
                         isOdd = j % 2 != 0;
                         break;
                     }
                     j++;
                 }
                 int k = j + 1;
                 while (k < A.length) {
                     if (k % 2 != A[k] % 2) {
                         //如果之间j是奇数，那么要求A[k]也必须是奇数
                         //如果j是偶数，那么A[k]也必须是偶数
                         if ((isOdd && A[k] % 2 == 1) || (!isOdd && A[k] % 2 == 0)) {
                             break;
                         }
                     }
                     k++;
                 }
                 if (k < A.length) {
                     int temp = A[j];
                     A[j] = A[k];
                     A[k] = temp;
                 }
                 i = j + 1;
             }
             return A;
         }*/
        //双指针解法
        public int[] sortArrayByParityII(int[] A) {
            //i，j分别指向偶数下标和奇数下标，每次移动两位即可
            int j = 1;
            for (int i = 0; i < A.length; i += 2) {
                if (A[i] % 2 != 0) {
                    while (j < A.length && A[j] % 2 == 1)
                        j += 2;
                    if (j < A.length) {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                    }
                }
            }
            return A;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{2, 0, 3, 4, 1, 3};
        int[] arr = new Solution().sortArrayByParityII(A);
        System.out.println(Arrays.toString(arr));
    }
}
