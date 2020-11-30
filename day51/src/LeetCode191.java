/**
 * @author Zixiang Hu
 * @description
 * @create 2020-07-05-18:51
 */
public class LeetCode191 {
    public int hammingWeight(int n) {
        int ans = 0;
        int i = 1;
        while (i != 0) {
            if ((n & i) != 0)
                ans++;
            i <<= 1;
        }
        return ans;
    }
}
