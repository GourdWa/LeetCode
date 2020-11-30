import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 763. 划分字母区间
 * @create 2020-10-22-8:45
 */
public class LeetCode763 {
    static class Solution {
        /*public List<Integer> partitionLabels(String S) {
            if (S == null || "".equals(S))
                return new ArrayList<>();
            int[][] character = new int[26][2];
            List<Integer> ans = new ArrayList<>();
            //记录下一个字母最左边的位置和最右边的位置
            for (int i = 0; i < S.length(); i++) {
                int ch = S.charAt(i) - 'a';
                if (character[ch][0] == 0 && ch != (S.charAt(0) - 'a')) {
                    character[ch][0] = i;
                    character[ch][1] = i;
                } else {
                    character[ch][1] = i;
                }
            }
            int right = character[S.charAt(0) - 'a'][1];
            int left = character[S.charAt(0) - 'a'][0];
            while (right < S.length()) {
                for (int i = left; i <= right; i++) {
                    if (right == S.length() - 1) {
                        ans.add(right - left + 1);
                        return ans;
                    }
                    if (i == right) {
                        ans.add(right - left + 1);
                        left = character[S.charAt(right + 1) - 'a'][0];
                        right = character[S.charAt(right + 1) - 'a'][1];
                        break;
                    }
                    if (character[S.charAt(i) - 'a'][1] > right) {
                        right = character[S.charAt(i) - 'a'][1];
                    }
                }
            }
            return ans;
        }*/
        public List<Integer> partitionLabels(String S) {
            if (S == null || "".equals(S))
                return new ArrayList<>();
            int[] pos = new int[26];
            List<Integer> ans = new ArrayList<>();
            //记录下每个字符最远的位置
            for (int i = 0; i < S.length(); i++) {
                int ch = S.charAt(i) - 'a';
                pos[ch] = i;
            }
            int start = 0;
            int maxPos = pos[S.charAt(0) - 'a'];
            for (int i = 0; i < S.length(); i++) {
                int cur = pos[S.charAt(i) - 'a'];
                maxPos = Math.max(maxPos, cur);
                if (maxPos == i) {
                    ans.add(maxPos - start + 1);
                    start = maxPos + 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partitionLabels("abbbbac"));
    }
}
