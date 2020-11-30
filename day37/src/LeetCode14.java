/**
 * @author Zixiang Hu
 * @description 14. 最长公共前缀
 * @create 2020-06-15-20:51
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int len = strs[0].length();
        int i;
        for (i = 0; i < len; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch != strs[j].charAt(i))
                    return strs[0].substring(0, i);
            }
        }

        return strs[0];
    }
}
