/**
 * @author Zixiang Hu
 * @description 557. 反转字符串中的单词 III
 * @create 2020-08-31-8:45
 */
public class LeetCode557 {
    class Solution {
        public String reverseWords(String s) {
                if (s == null || s.length() == 0)
                    return s;
                char[] chs = s.toCharArray();
                int l = 0, r = 0;
                while (r < chs.length) {
                    while (r < chs.length && chs[r] != ' ')
                        r++;
                    //说明r指向的位置是空格或者已经是最后一位
                    int pos = r; //记录下r的位置
                    r = r - 1;//使r指向一个有效字符
                    while (l <= r) {
                        char exch = chs[l];
                        chs[l] = chs[r];
                        chs[r] = exch;
                        l++;
                        r--;
                    }
                    r = pos + 1;
                    l = pos + 1;
                }
                return new String(chs);
        }
    }
}
