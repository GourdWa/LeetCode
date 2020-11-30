import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 93. 复原IP地址
 * @create 2020-08-09-9:22
 */
public class LeetCode93 {
    static class Solution {
        //存储四个片段的结束位置
        int[] pos = new int[4];

        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            if (s.length() >= 4 && s.length() <= 16)
                dfs(s, 0, 0, ans);
            return ans;
        }

        /**
         * @param s
         * @param start 第i个片段的开始位置
         * @param index 第index片段，一共是0,1,2,3四个片段
         * @param ans
         */
        private void dfs(String s, int start, int index, List<String> ans) {
            if (index == 4 && start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < pos.length; i++) {
                    if (i == 0) {
                        sb.append(s.substring(0, pos[i]));
                        sb.append('.');
                    } else if (i == 3)
                        sb.append(s.substring(pos[i - 1], pos[i]));
                    else {
                        sb.append(s.substring(pos[i - 1], pos[i]));
                        sb.append('.');
                    }
                }
                ans.add(sb.toString());
            }
            if (index == 4 || start >= s.length())
                return;
            //如果是0开头的，只能单独做一个ip片段
            if (s.charAt(start) == '0') {
                pos[index] = start + 1;
                dfs(s, start + 1, index + 1, ans);
                return;
            }
            int addr = 0;
            for (int i = start; i < s.length(); i++) {
                addr = addr * 10 + s.charAt(i) - '0';
                if (addr <= 255) {
                    pos[index] = i + 1;
                    dfs(s, i + 1, index + 1, ans);
                } else
                    break;
            }
        }


        //暴力，遍历可以三个点可以插入的位置
     /*   public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            int sLen = s.length();
            if (sLen >= 4 && sLen <= 16) {
                int a, b, c;
                for (a = 1; a < 4 && a < sLen; a++) {
                    for (b = a + 1; b < a + 4 && b < sLen; b++) {
                        for (c = b + 1; c < b + 4 && c < sLen; c++) {
                            String aa = s.substring(0, a);
                            String bb = s.substring(a, b);
                            String cc = s.substring(b, c);
                            String dd = s.substring(c, sLen);
                            if (valid(aa) && valid(bb) && valid(cc) && valid(dd)) {
                                ans.add(aa + '.' + bb + '.' + cc + '.' + dd);
                            }
                        }
                    }
                }
            }
            return ans;
        }

        boolean valid(String s) {
            if (s.length() == 1) return true;
            if (s.length() > 3) return false;
            if (s.charAt(0) == '0') return false;
            if (Integer.parseInt(s) <= 255) return true;
            return false;
        }*/


    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("010010"));
    }
}
