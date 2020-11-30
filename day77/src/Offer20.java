/**
 * @author Zixiang Hu
 * @description 剑指 Offer 20. 表示数值的字符串
 * @create 2020-09-02-8:55
 */
public class Offer20 {
    class Solution {
        public boolean isNumber(String s) {
            //去除两端的无效空格
            s = s.trim();
            if (s.length() < 1)
                return false;
            //同于标记是否出现过.
            boolean hasDot = false;
            //是否出现过e
            boolean hasE = false;
            //是否出现过数字
            boolean hasNum = false;
            //e出现的位置
            int ePos = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                //是否出现过e
                if (!hasE) {
                    if (ch == '.') {
                        //已经出现过
                        if (hasDot)
                            return false;
                        //小数点的左右两边必须有一个是数字
                        if (!(i - 1 >= 0 && Character.isDigit(s.charAt(i - 1)))) {
                            if (!(i + 1 < len && Character.isDigit(s.charAt(i + 1))))
                                return false;
                        }
                        hasDot = true;
                    } else if (ch == '+' || ch == '-') {
                        //如果是正负号，则必须要求出现在第0位，且之后必须有数字
                        if (i != 0 || i + 1 >= len)
                            return false;
                    } else if (ch == 'e' || ch == 'E') {
                        //如果出现e的时候没有出现过数字或者e是最后一位则返回false
                        if (!hasNum || i + 1 >= len)
                            return false;
                        hasE = true;
                        ePos = i;
                    } else if (ch < '0' || ch > '9')//如果不是数字直接返回false
                        return false;
                    else
                        hasNum = true;
                } else {
                    //e的后面不能有再出现.或者e
                    if (ch == '.' || ch == 'e' || ch == 'E')
                        return false;
                    //如果出现了正负号，正负号必须是e之后的第一位，且不能是最后一位
                    if (ch == '+' || ch == '-') {
                        if (ePos + 1 != i || i + 1 >= len)
                            return false;
                    } else if (ch < '0' || ch > '9')
                        return false;
                }
            }
            return true;
        }
    }

}
