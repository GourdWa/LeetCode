import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Zixiang Hu
 * @description 316. 去除重复字母
 * @create 2020-11-16-16:26
 */
public class LeetCode316 {


    class Solution {
        public String removeDuplicateLetters(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (!stack.contains(ch)) {
                    Character peekCh = stack.peek();
                    while (!stack.isEmpty() && map.get(peekCh) > 1 && peekCh > ch) {
                        map.put(peekCh, map.get(peekCh) - 1);
                        stack.pop();
                        if (!stack.isEmpty())
                            peekCh = stack.peek();
                    }
                    stack.push(ch);
                } else
                    map.put(ch, map.get(ch) - 1);
            }
            StringBuilder sb = new StringBuilder();
            for (Character ch : stack) {
                if (map.get(ch) == 1)
                    sb.append(ch);
                else
                    map.put(ch, map.get(ch) - 1);
            }
            return sb.reverse().toString();
        }
    }
}
