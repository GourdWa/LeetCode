package com.learn.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ZixiangHu
 * @create 2020-06-07  19:20
 * @description 127. 单词接龙
 */
public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0 || !wordList.contains(endWord))
            return 0;
        int cnt = 0;
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String pollStr = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if (!visited[j] && isMatch(pollStr, wordList.get(j))) {
                        visited[j] = true;
                        if (wordList.get(j).equals(endWord))
                            return cnt + 1;
                        queue.add(wordList.get(j));
                    }
                }
            }
        }
        return 0;
    }

    public boolean isMatch(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1)
                    break;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {

    }
}
