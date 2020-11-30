package com.learn.domain;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZixiangHu
 * @create 2020-05-26  22:13
 * @description 22. 括号生成
 */
public class LeetCode22 {
    private char[] chs;

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n <= 0)
            return ans;
        chs = new char[2 * n];

        dfs(ans, 0, 0, 0);
        return ans;
    }

    public void dfs(List<String> ans, int pos, int neg, int i) {
        if (neg > pos || pos > chs.length / 2) {
            return;
        } else if (i == chs.length) {
            ans.add(new String(chs));
        } else {
            chs[i] = '(';
            dfs(ans, pos + 1, neg, i + 1);
            chs[i] = ')';
            dfs(ans, pos, neg + 1, i + 1);
        }
    }

    public static void main(String[] args) {
        new LeetCode22().generateParenthesis(2);
    }
}
