package com.learn.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZixiangHu
 * @create 2020-05-19  16:03
 * @description 全排列
 */
public class LeetCode46 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;
    int[] list;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length > 0) {
            visited = new boolean[nums.length];
            list = new int[nums.length];
            dfs(nums, 0);
        }

        return ans;
    }

    private void dfs(int[] nums, int count) {
        if (count == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i : list) {
                temp.add(i);
            }
            ans.add(temp);
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list[count] = nums[i];
                    dfs(nums, count + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode46().permute(new int[]{1, 2, 3});
    }
}
