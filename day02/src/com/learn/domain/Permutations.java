package com.learn.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZixiangHu
 * @create 2020-05-07  23:44
 * @description LeetCode 46
 */
public class Permutations {
    private boolean[] isVisited;

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int[] list = new int[len];
        isVisited = new boolean[len];
        dfs(0, list, nums, ans);
        return ans;
    }

    private void dfs(int i, int[] list, int[] nums, List<List<Integer>> ans) {
        if (i == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int ele : list) {
                temp.add(ele);
            }
            ans.add(temp);
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!isVisited[j]) {
                isVisited[j] = true;
                list[i] = nums[j];
                dfs(i + 1, list, nums, ans);
                isVisited[j] = false;
            }
        }
    }


    public static void main(String[] args) {

    }
}
