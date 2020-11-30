package com.learn.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZixiangHu
 * @create 2020-05-23  13:24
 * @description
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 1;
        int len = 0;
        while (right < chs.length) {
            char ch = chs[right];
            if (map.containsKey(ch) && map.get(ch) != -1) {
                while (left < right) {
                    char c = chs[left];
                    map.put(c, -1);

                    if (c == ch) {
                        maxLen = Math.max(maxLen, len);
                        map.put(c, right);
                        len = right - left;
                        left++;
                        break;
                    }
                    left++;
                }
            } else {
                maxLen = Math.max(maxLen, len);
                map.put(ch, right);
                len++;
            }
            right++;
        }
        return Math.max(maxLen, right - left);
    }

    public static void main(String[] args) {
        new LeetCode3().lengthOfLongestSubstring("tmmzuxt");
    }
}
