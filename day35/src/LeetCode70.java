/**
 * @author Zixiang Hu
 * @description 70. 爬楼梯
 * @create 2020-06-13-18:26
 */
public class LeetCode70 {
    public int climbStairs(int n) {
        int firstStep = 1;
        int secondStep = 2;
        int totalStep = 0;
        if (n == 1)
            return firstStep;
        if (n == 2)
            return secondStep;

        for (int i = 3; i <= n; i++) {
            totalStep = firstStep + secondStep;
            firstStep = secondStep;
            secondStep = totalStep;
        }
        return totalStep;
    }
}
