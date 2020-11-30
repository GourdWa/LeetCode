/**
 * @author Zixiang Hu
 * @description 134. 加油站
 * @create 2020-11-18-9:04
 */
public class LeetCode134 {
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            for (int i = 0; i < gas.length; i++) {
                if (gas[i] >= cost[i]) {
                    int balance = gas[i];
                    int j = i;
                    while (j <= i + gas.length) {
                        if (j == i + gas.length)
                            return i;
                        balance -= cost[j % gas.length];
                        if (balance >= 0) {
                            j++;
                            balance += gas[j % gas.length];
                        } else {
                            i = Math.max(j % gas.length, i + 1);
                            break;
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }
}
