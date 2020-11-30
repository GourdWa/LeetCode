package com.learn.domain;

import java.util.Arrays;

/**
 * @author ZixiangHu
 * @create 2020-06-08  10:18
 * @description
 */
public class LeetCode990 {
    public boolean equationsPossible(String[] equations) {
        int[] equal = new int[26];
        Arrays.fill(equal, -1);
        for (String equation : equations) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            if (a == b)
                if (equation.charAt(1) == '!')
                    return false;
                else
                    continue;
            else if (equation.charAt(1) == '=') {
                //也就是大家都是第一次出现
                if (equal[a - 'a'] == -1 && equal[b - 'a'] == -1) {
                    //令他们对应的数组的值相等
                    equal[a - 'a'] = a;
                    equal[b - 'a'] = a;
                } else if (equal[a - 'a'] != -1 && equal[b - 'a'] == -1) {
                    //如果其中一个字符已经出现过等式，那么令未出现的字符数组的值等于已出现的值
                    equal[b - 'a'] = equal[a - 'a'];
                } else if (equal[a - 'a'] == -1 && equal[b - 'a'] != -1) {
                    //如果其中一个字符已经出现过等式，那么令未出现的字符数组的值等于已出现的值
                    equal[a - 'a'] = equal[b - 'a'];
                } else if (equal[a - 'a'] != equal[b - 'a']) {
                    //如果两个都出现过了,比如a=b;c=d;a=d。因为a、b和c、d都有值了，但是此时出现了a=d，可知推出a,b,c,d都相等
                    //因此此时将其中一个出现的值用另一个值代替
                    int t = equal[b - 'a'];
                    for (int i = 0; i < equal.length; i++) {
                        if (equal[i] == t)
                            equal[i] = equal[a - 'a'];
                    }
                }
            }
        }
        for (String equation : equations) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            if (equation.charAt(1) == '!') {
                if (equal[a - 'a'] == equal[b - 'a'] && equal[b - 'a'] != -1)
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode990().equationsPossible(new String[]{"a==b", "e==c", "b==c", "a!=e"}));
    }
}
