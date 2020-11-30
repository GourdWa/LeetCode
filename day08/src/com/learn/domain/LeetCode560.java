package com.learn.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-15  13:05
 * @description 560. 和为K的子数组
 */
public class LeetCode560 {
    /*     public int subarraySum(int[] nums, int k) {
             int cnt = 0;
             int sub = 0;
             for (int i = 0; i < nums.length; i++) {
                 sub = 0;
                 for (int j = i; j < nums.length; j++) {
                     sub += nums[j];
                     if (sub == k) {
                         cnt++;
                     }
                 }
             }
             return cnt;
         }*/
    //sum[i] - sum[j] 就是(j,i)之间连续数组的和
    //如果sum[i] - sum[j] = k,那我们就可以进行计数了，这里也可以进行一次变形sum[j] = sum[i] - k
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                result += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode560().subarraySum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0}, 0));
    }
}
