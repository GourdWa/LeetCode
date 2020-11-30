package com.learn.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ZixiangHu
 * @create 2020-05-07  19:42
 * @description LeetCode 3
 */
public class LeetCode03 {
    //    "abcabcbb"
//    "pwwkew"
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //说明字符c已经在前面出现过了
            if (map.containsKey(c)) {
                cnt2 = Math.max(cnt1, cnt2);
                //拿到字符c第一次出现的位置
                int pos = map.get(c);
                //这里主要是规避abba这种情况，比如b先与a重复出现，
                // 此时cnt1应该从第二个b之后的字符串，第二个b之前的字符串应该舍弃
                //如果cnt1指向第二个a时，因为两个a之间已经出现过两个b了，所以此时两个a之间的距离就没有意义了
                // 只需要将cnt1继续往后扫描即可
                //问题的关键是要判断两个a之间是否出现过另外的重复字符，可以利用到就是如果两个a之间没有重复的字符，
                // 那么此时cnt1必然是等于第二个a减第一个a的位置的，如果不等，则说明他们之间出现过重复的字符
                if (i - pos > cnt1)
                    cnt1++;
                else
                    cnt1 = i - pos;
            } else
                cnt1++;
            map.put(c, i);
        }
        return Math.max(cnt1, cnt2);
    }

/*    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int left = 0,right = 0,longestSubString = 0;
        while(right < s.length() && left < s.length())
        {
            if(!set.contains(s.charAt(right)))
            {
                set.add(s.charAt(right));
                right ++;
                longestSubString = longestSubString > right - left ? longestSubString :right - left;
            }
            else
            {
                set.remove(s.charAt(left ++));
            }
        }
        return longestSubString;
    }*/

    public static void main(String[] args) {
        String s = "abba";
        int longestSubstring = new LeetCode03().lengthOfLongestSubstring(s);
        System.out.println(longestSubstring);
    }
}
