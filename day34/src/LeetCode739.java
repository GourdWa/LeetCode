import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Zixiang Hu
 * @description 739. 每日温度
 * @create 2020-06-12-17:01
 */
public class LeetCode739 {
    /*    public int[] dailyTemperatures(int[] T) {
            if (T == null || T.length == 0)
                return new int[]{};
            int[] ans = new int[T.length];
            for (int i = 0; i < T.length; i++) {
                int cnt = 1;
                for (int j = i + 1; j < T.length; j++) {
                    if (T[j] > T[i]) {
                        ans[i] = cnt;
                        break;
                    }
                    cnt++;
                }
            }
            return ans;
        }*/
   /* public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return new int[]{};
        int[] ans = new int[T.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int popEle = stack.pop();
                ans[popEle] = i - popEle;
            }
            stack.push(i);
        }
        return ans;
    }*/
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return new int[]{};
        int[] ans = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            //直接移动到大于第j个元素的位置
            for (int j = i + 1; j < T.length; j += ans[j]) {
                if (T[j] > T[i]) {
                    ans[i] = j - i;
                    break;
                } else if (ans[j] == 0) {
                    //如果ans[j]等于0，说明没有比第j位大的元素，又因T[j] <= T[i]，因此ans[i]=0
                    ans[i] = 0;
                    break;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
