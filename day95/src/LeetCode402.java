import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 402. 移掉K位数字
 * @create 2020-11-15-19:01
 */
public class LeetCode402 {
    class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Integer> stack = new LinkedList<>();
            StringBuilder sb = new StringBuilder(0);
            for (int i = 0; i < num.length(); i++) {
                int ele = num.charAt(i) - '0';
                while (k > 0 && stack.size() != 0 && ele < stack.peek()) {
                    stack.pop();
                    k--;
                }
                stack.push(ele);
            }
            while (k-- > 0) {
                stack.pop();
            }
            if (stack.isEmpty())
                return "0";
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            String ans = sb.reverse().toString();
            int i = 0;
            while (i < ans.length() && ans.charAt(i) == '0') {
                i++;
            }
            return i == ans.length() ? "0" : ans.substring(i);
        }
    }

    public static void main(String[] args) {

    }
}
