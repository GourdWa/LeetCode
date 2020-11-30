package com.learn.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZixiangHu
 * @create 2020-06-01  19:29
 * @description 1431. 拥有最多糖果的孩子
 */
public class LeetCode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        if (candies.length == 0)
            return ans;
        int max = candies[0];
        for (int candy : candies) {
            max = candy > max ? candy : max;
        }
        for (int candy : candies) {
            if (candy + extraCandies >= max)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }
}
