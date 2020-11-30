package com.learn.domain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZixiangHu
 * @create 2020-06-04  20:09
 * @description 32. 最长有效括号
 */
public class LeetCode32 {
    //结合20题的有效括号，暴力枚举超时
//    public int longestValidParentheses(String s) {

    //        if (s == null || s.length() < 1)

    //            return 0;

    //        int maxLen = 0;

    //        for (int i = 0; i < s.length(); i++) {

    //            for (int j = i + 1; j < s.length(); j++) {

    //                if (isValid(s.substring(i, j + 1))) {

    //                    maxLen = maxLen > j - i ? maxLen : j - i + 1;

    //                }

    //            }

    //        }

    //        return maxLen;

    //    }

    //

    //    public boolean isValid(String s) {

    //        Deque<Character> stack = new LinkedList<>();

    //        stack.push(s.charAt(0));

    //        int i = 1;

    //        while (i < s.length()) {

    //            if (stack.isEmpty()) {

    //                stack.push(s.charAt(i));

    //                i++;

    //                continue;

    //            }

    //            char peekCh = stack.peek();

    //            char posCh = s.charAt(i);

    //            if ((peekCh == '(' && posCh == ')') || (peekCh == '[' && posCh == ']') || (peekCh == '{' && posCh == '}'))

    //                stack.pop();

    //            else

    //                stack.push(posCh);

    //            i++;

    //        }

    //        return stack.isEmpty();

    //    }

    public static void main(String[] args) {
        System.out.println(new LeetCode32().longestValidParentheses("(()"));
    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 1)
            return 0;
        char[] chs = s.toCharArray();
        //dp[i]代表以i结尾的最长有效括号，可知，如果chs[i]为(，那么dp[i]=0
        //如果chs[i]=)，则需要分情况讨论递推公式
        int[] dp = new int[chs.length];
        int maxLen = 0;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == ')') {
                //如果是...()这样的形式
                if (chs[i - 1] == '(') {
                    if (i - 2 > 0)
                        dp[i] = dp[i - 2] + 2;
                    else
                        dp[i] = 2;
                } else if (chs[i - 1] == ')') {
                    //如果是...((...))这样的形式
                    int pos = i - dp[i - 1] - 1;
                    if (pos >= 0 && chs[pos] == '(') {
                        if (pos - 1 >= 0)
                            dp[i] = dp[pos - 1] + dp[i - 1] + 2;
                        else
                            dp[i] = dp[i - 1] + 2;
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}
