package com.learn.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-31  15:31
 * @description
 */
public class LeetCode76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        int start = 0;
        int end = 0;
        int left = 0;
        int right = 0;
        int minLen = s.length() + 1;
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char tChar : tChars) {
            needs.put(tChar, needs.getOrDefault(tChar, 0) + 1);
        }
        int match = 0;
        while (right < sChars.length) {
            char ch = sChars[right];
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if (needs.containsKey(ch) && needs.get(ch) == window.get(ch)) {
                match++;
            }
            while (match == needs.size()) {
                if (right - left < minLen) {
                    start = left;
                    end = right + 1;
                    minLen = right - left;
                }
                char ch2 = sChars[left];
                left += 1;
                window.put(ch2, window.get(ch2) - 1);
                if (needs.containsKey(ch2) && needs.get(ch2) > window.get(ch2))
                    match--;
            }
            right += 1;
        }
        return s.substring(start, end);
    }
}
