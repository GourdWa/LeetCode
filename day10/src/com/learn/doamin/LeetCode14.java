package com.learn.doamin;

/**
 * @author ZixiangHu
 * @create 2020-05-17  20:18
 * @description
 */
public class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null)
            return "";
        int len = strs[0].length();
        StringBuilder sb = new StringBuilder();
        int pos;
        int i;
        for (pos = 0; pos < len; pos++) {
            char ch = strs[0].charAt(pos);
            for (i = 0; i < strs.length; i++) {
                if (strs[i].length() > pos || strs[i].charAt(pos) != ch)
                    break;
            }
            if (i < strs.length)
                break;
            else
                sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new LeetCode14().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }
}
