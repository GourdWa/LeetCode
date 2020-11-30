package com.learn.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-27  10:53
 * @description
 */
public class LeetCode974 {
    //暴力，超时
/*    public int subarraysDivByK(int[] A, int K) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum = (sum + A[j]) % K;
                if (sum == 0)
                    ans++;
            }
        }
        return ans;
    }*/

        public int subarraysDivByK(int[] A, int K) {
            int ans = 0;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            for (int ele : A) {
                sum += ele;
                int modVal = (sum % K + K) % K;
                if (map.containsKey(modVal))
                    ans += map.get(modVal);
                map.put(modVal,  map.getOrDefault(modVal, 0) + 1);
            }
            return ans;
        }
/*    public int subarraysDivByK(int[] A, int K) {
        int ans = 0;
        int sum = 0;
        int[] mod = new int[K];
        mod[0] = 1;
        for (int ele : A) {
            //这样做是保证余数为正数
            sum = ((sum + ele) % K + K) % K;
            ans += mod[sum];
            mod[sum]++;
        }
        return ans;
    }*/


    public static void main(String[] args) {
        System.out.println(-5 % 5);
    }
}
