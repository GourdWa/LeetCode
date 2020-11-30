import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Zixiang Hu
 * @description 面试题 17.13. 恢复空格
 * @create 2020-07-09-16:53
 */
public class LeetCode17_13 {
    public static int respace(String[] dictionary, String sentence) {
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        //dp[i]代表前i个字符中未匹配的个数，默认情况下dp[i]=dp[i-1]+1
        int[] dp = new int[n + 1];
        /*for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int idx = 0; idx < i; idx++) {
                if (dict.contains(sentence.substring(idx, i))) {
                    dp[i] = Math.min(dp[i], dp[idx]);
                }
            }
        }*/

        return dp[n];
    }

    public static void main(String[] args) {
        respace(new String[]{"abcd", "ab", "def"}, "abcdef");
    }
}
