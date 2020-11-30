/**
 * @author Zixiang Hu
 * @description 767. 重构字符串
 * @create 2020-11-30-9:14
 */
public class LeetCode767 {
    static class Solution {
        public String reorganizeString(String S) {
            int[] chs = new int[26];
            //出现次数最多的字符和次数
//            int maxCnt = 0;
            int c = 0;
            for (int i = 0; i < S.length(); i++) {
                int j = S.charAt(i) - 'a';
                chs[j]++;
                if (chs[j] > chs[c]) {
//                    maxCnt = chs[j];
                    c = j;
                }
            }
            if (2 * chs[c] - 1 <= S.length()) {
                char[] res = new char[S.length()];
                int index = 0;
                while (chs[c] > 0) {
                    res[index] = (char) (c + 'a');
                    chs[c]--;
                    index += 2;
                }
                for (int i = 0; i < 26; i++) {
                    while (chs[i]-- > 0) {
                        if (index > S.length()) {
                            index = 1;
                        }
                        res[index] = (char) (i + 'a');
                        index += 2;
                    }
                }
                return new String(res);
            }
            return "";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reorganizeString("vvvol");
    }
}
