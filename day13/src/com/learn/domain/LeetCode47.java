package com.learn.domain;

import java.util.*;

/**
 * @author ZixiangHu
 * @create 2020-05-20  12:27
 * @description 全排列 返回不重复的全排列
 */
public class LeetCode47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
//        Set<String> set = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        int[] ls = new int[nums.length];
        if (nums != null && nums.length > 0)
            dfs(nums, 0, visited, ls, ans, map);
        return ans;
    }

    private void dfs(int[] nums, int count, boolean[] visited, int[] ls, List<List<Integer>> ans, Map<String, String> map) {
        if (count == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int ele : ls) {
                list.add(ele);
                sb.append(ele);
            }
            if (map.getOrDefault(sb.toString(), " ") == " ") {
                map.put(sb.toString(), sb.toString());
                ans.add(list);
            }
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    ls[count] = nums[i];
                    dfs(nums, count + 1, visited, ls, ans, map);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode47().permuteUnique(new int[]{1, 1, 2});
    }

}
