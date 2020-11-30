import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zixiang Hu
 * @description 225. 用队列实现栈
 * @create 2020-07-01-15:45
 */
public class LeetCode225 {
    class MyStack {

        private Queue<Integer> queue1 = new LinkedList<>();
        private Queue<Integer> queue2 = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public MyStack() {

        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue1.add(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            if (queue1.size() == 0) {
                while (queue2.size() > 1)
                    queue1.add(queue2.poll());
                return queue2.poll();
            } else
                return queue1.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            int ans = -1;
            while (queue1.size() > 1)
                queue2.add(queue1.poll());
            if (queue1.size() == 0) {
                while (queue2.size() > 1)
                    queue1.add(queue2.poll());
                ans = queue2.poll();
                queue1.add(ans);
            } else {
                ans = queue1.poll();
                queue2.add(ans);
            }
            return ans;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }
}
