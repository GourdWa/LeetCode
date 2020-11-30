import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Zixiang Hu
 * @description 剑指 Offer 09. 用两个栈实现队列
 * @create 2020-06-30-10:51
 */
public class Offer9 {
    //非最优解答
 /*   class CQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            int ans = -1;
            while (stack1.size() > 1)
                stack2.push(stack1.pop());
            if (stack1.size() == 1)
                ans = stack1.pop();
            while (!stack2.isEmpty())
                stack1.push(stack2.pop());
            return ans;
        }
    }*/
    class CQueue {
        private Deque<Integer> stack1 = new LinkedList<>();
        private Deque<Integer> stack2 = new LinkedList<>();
        private int size = 0;

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
            size++;
        }

        public int deleteHead() {
            int ans = -1;
            if (size != 0) {
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty())
                        stack2.push(stack1.pop());
                }
                ans = stack2.pop();
                size--;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        CQueue cQueue = new Offer9().new CQueue();
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
