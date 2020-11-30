package com.learn.domain;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZixiangHu
 * @create 2020-05-28  13:26
 * @description
 */
public class LeetCode394 {
    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chs = s.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < chs.length) {
            char ch = chs[i];
            if (ch == ']') {
                String str = "";
                String string = "";
                while (true) {
                    char popCh = stack.pop();
                    if (popCh != '[')
                        str = popCh + str;
                    else if (!stack.isEmpty()) {
                        String n = "";
                        char peekCh = stack.peek();
                        while (!stack.isEmpty() && peekCh <= '9' && peekCh >= '0') {
                            stack.pop();
                            n = peekCh + n;
                            if (!stack.isEmpty())
                                peekCh = stack.peek();
                        }
                        for (int j = 0; j < Integer.parseInt(n); j++) {
                            string += str;
                        }
                        break;
                    }
                }
                if (stack.isEmpty())
                    sb.append(string);
                else
                    for (int j = 0; j < string.length(); j++) {
                        stack.push(string.charAt(j));
                    }
            } else {
                stack.push(ch);
            }
            i++;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode394().decodeString("2[abc]3[cd]ef"));

    }
}
