/**
 * @author Zixiang Hu
 * @description 925. 长按键入
 * @create 2020-10-21-8:46
 */
public class LeetCode925 {
    static class Solution {
        public boolean isLongPressedName(String name, String typed) {
            boolean[] dp = new boolean[typed.length()];
            //dp[i]为true代表typed的前i个字符与name的前j个字符匹配
            dp[0] = (name.charAt(0) == typed.charAt(0));
            int i, j = 1;
            for (i = 1; i < typed.length(); i++) {
                if (j < name.length() && dp[i - 1] && name.charAt(j) == typed.charAt(i)) {
                    dp[i] = true;
                    j++;
                } else if (dp[i - 1] && typed.charAt(i - 1) == typed.charAt(i)) {
                    dp[i] = true;
                }
            }
            return dp[typed.length() - 1] && j == name.length();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isLongPressedName("pyplrz", "ppyypllr"));
    }
}
