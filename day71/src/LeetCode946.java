import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Zixiang Hu
 * @description 946. 验证栈序列
 * @create 2020-08-15-20:04
 */
public class LeetCode946 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new LinkedList<>();
            int i = 0;
            for (int popEle : popped) {
                //如果此时辅助栈为空，则向里面push数据，直到push的数据等于popEle为止
                //如果此时栈顶元素不等于popEle，也继续向栈中添加元素
                if (stack.isEmpty() || (popEle != stack.peek())) {
                    while (i < pushed.length && pushed[i] != popEle) {
                        stack.push(pushed[i]);
                        i++;
                    }
                    //如果push到最后都没有找到popEle，则返回false
                    if (i == pushed.length)
                        return false;
                    else {
                        //说明push[i]==popEle，则让i++，并将这个元素入栈
                        stack.push(pushed[i]);
                        i++;
                    }
                }
                //到这步，说明栈肯定不为空，并且栈顶元素一定等于popEle，此时将其弹出即可
                stack.pop();
            }
            return true;
        }
    }
}
