package com.learn.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZixiangHu
 * @create 2020-05-19  11:35
 * @description
 */
public class LeetCode17 {
    String[] strings = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        if (digits.length() > 0) {
            dfs(digits, new StringBuilder(), 0, list);
        }

        return list;
    }

    private void dfs(String digits, StringBuilder sb, int i, List<String> list) {
        if (sb.length() == digits.length()) {
            list.add(sb.toString());
            return;
        } else {
            int pos = digits.charAt(i) - '0' - 2;
            char[] chars = strings[pos].toCharArray();
            for (char aChar : chars) {
                dfs(digits, sb.append(aChar), i + 1, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new LeetCode17().letterCombinations("23");
    }
}
