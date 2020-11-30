package com.learn.domain;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZixiangHu
 * @create 2020-05-21  12:11
 * @description
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Deque<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        int i = 1;
        while (i < s.length()) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                i ++;
                continue;
            }
            char peekCh = stack.peek();
            char posCh = s.charAt(i);
            if ((peekCh == '(' && posCh == ')') || (peekCh == '[' && posCh == ']') || (peekCh == '{' && posCh == '}'))
                stack.pop();
            else
                stack.push(posCh);
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        new LeetCode20().isValid("()[]{}");
    }
}
