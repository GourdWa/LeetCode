package com.learn.domain;

import java.util.*;

/**
 * @author ZixiangHu
 * @create 2020-05-31  11:48
 * @description
 */

/*        for (int i = 0; i <= len; i++) {
            int right = i;
            int left = i;
            int match = 0;
            windows.putAll(needs);
            while (right <= s.length() - allLen) {
                String subStr = s.substring(right, right + len);
                right += len;
                if (windows.containsKey(subStr) && windows.get(subStr) > 0) {
                    match++;
                    windows.put(subStr, windows.get(subStr) - 1);
                    if (match == size) {
                        res.add(left);
                        String subStr2 = s.substring(left, left + len);
                        left += len;
                        windows.put(subStr2, windows.get(subStr2) + 1);
                        match--;
                    }
                } else {
                    windows.putAll(needs);
                }
            }
        }*/
public class LeetCode30 {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        // 如果目标数组为空，则返回一个空集合
        if (words.length == 0) {
            return res;
        }
        // 单词长度
        int len = words[0].length();
        //单词个数
        int size = words.length;
        // 定义两个map集合，一个存目标单词，一个存滑动窗口
        Map<String, Integer> needs = new HashMap<>();
        Map<String, Integer> windows = new HashMap<>();
        // 初始化目标集合，将单词与出现的次数对应存入map集合中
        for (int i = 0; i < words.length; i++) {
            int count = needs.getOrDefault(words[i], 0);
            needs.put(words[i], count + 1);
        }
        for (int i = 0; i < len; i++) {
            int right = i;
            int left = i;
            int match = 0;
            while (right <= s.length() - len) {
                String subStr = s.substring(right, right + len);
                right += len;
                windows.put(subStr, windows.getOrDefault(subStr, 0) + 1);
                //如果条件成立，说明一个类型的单词已经匹配成功了
                if (needs.containsKey(subStr) && windows.get(subStr) == needs.get(subStr))
                    match++;
                //匹配成功的单词的类型等于words中单词的类型
                while (match == needs.size()) {
                    //为什么要加这句呢？
                    //因为如果words={pos,abc}，left与right之间为：posbfcabc，这样left与right之间的单词也包含了所有words中的单词
                    //但是此时left很明显不符合要求,因此必须要求left与right之间的单词个数等于单个单词长度乘单词个数
                    if ((right - left) / len == size)
                        res.add(left);
                    String subStr2 = s.substring(left, left + len);
                    left += len;
                    windows.put(subStr2, windows.get(subStr2) - 1);
                    if (needs.containsKey(subStr2) && needs.get(subStr2) > windows.get(subStr2))
                        match--;
                }
            }
            windows.clear();
        }
        return res;
    }

    public static void main(String[] args) {
//        new LeetCode30().findSubstring("barfoofoobarthefoobarman", new String[]{"foo", "bar", "the"});
        new LeetCode30().findSubstring("aaaa", new String[]{"a", "a"});


    }
}
