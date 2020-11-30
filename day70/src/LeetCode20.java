import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 20. 有效的括号
 * @create 2020-08-14-10:19
 */
public class LeetCode20 {
    static class Solution {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0)
                return true;
            Deque<Character> stack = new LinkedList<>();
            stack.push(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == ')' || ch == ']' || ch == '}') {
                    if (stack.isEmpty())
                        return false;
                    else {
                        if (ch == ')' && stack.peek() == '(')
                            stack.pop();
                        else if (ch == ']' && stack.peek() == '[')
                            stack.pop();
                        else if (ch == '}' && stack.peek() == '{')
                            stack.pop();
                        else
                            return false;
                    }
                } else
                    stack.push(ch);
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
    }
}
