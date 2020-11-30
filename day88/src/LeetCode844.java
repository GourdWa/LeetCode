import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Zixiang Hu
 * @description 844. 比较含退格的字符串
 * @create 2020-10-19-8:44
 */
public class LeetCode844 {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            Deque<Character> stack1 = new LinkedList<>();
            Deque<Character> stack2 = new LinkedList<>();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) != '#')
                    stack1.push(S.charAt(i));
                else if (!stack1.isEmpty())
                    stack1.pop();
            }
            for (int i = 0; i < T.length(); i++) {
                if (T.charAt(i) != '#')
                    stack2.push(T.charAt(i));
                else if (!stack2.isEmpty())
                    stack2.pop();
            }
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                if (stack1.pop() != stack2.pop())
                    return false;
            }
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
