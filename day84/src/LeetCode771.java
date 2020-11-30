/**
 * @author Zixiang Hu
 * @description 771. 宝石与石头
 * @create 2020-10-03-8:41
 */
public class LeetCode771 {
    class Solution {
        public int numJewelsInStones(String J, String S) {
            boolean[] chs = new boolean[57];
            int count = 0;
            for (int i = 0; i < J.length(); i++) {
                chs[J.charAt(i) - 'A'] = true;
            }
            for (int i = 0; i < S.length(); i++) {
                if (chs[S.charAt(i) - 'A'])
                    count++;
            }
            return count;
        }
    }
}
