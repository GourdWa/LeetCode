package com.learn.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-06  15:28
 * @description LeetCode 1 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
/*        int[] res = new int[2];
        int i = 0, j = 0;
        int div;
        for (i = 0; i < nums.length; i++) {
            div = target - nums[i];
            for (j = i + 1; j < nums.length; j++) {
                if (nums[j] == div){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }

        }
        return res;*/
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];
            if (map.containsKey(sub))
                return new int[]{map.get(sub), i};
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
