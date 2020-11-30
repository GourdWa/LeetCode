/**
 * @author Zixiang Hu
 * @description 696. 计数二进制子串
 * @create 2020-08-10-8:37
 */
public class LeetCode696 {
    class Solution {
        public int countBinarySubstrings(String s) {
            int ans = 0;
            int sLen = s.length();
            char[] chs = s.toCharArray();
            for (int i = 0; i < sLen - 1; i++) {
                //说明s的子串[i,i+1]符合要求，此时向左右两边扩展
                if (chs[i] != chs[i + 1]) {
                    ans ++;
                    int left = i - 1, right = i + 2;
                    while (left >= 0 && right < sLen) {
                        if (chs[left] == chs[i] && chs[right] != chs[i]) {
                            ans++;
                            left--;
                            right++;
                        } else
                            break;
                    }
                }
            }
            return ans;
        }
    }
}
