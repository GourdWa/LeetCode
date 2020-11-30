package com.learn.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-27  13:57
 * @description 560. 和为K的子数组
 */
public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k))
                ans += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
