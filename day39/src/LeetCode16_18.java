/**
 * @author Zixiang Hu
 * @description 面试题 16.18. 模式匹配
 * @create 2020-06-22-18:57
 */
public class LeetCode16_18 {
    class Solution {
        public boolean patternMatching(String pattern, String value) {
            if (pattern.equals("a") || pattern.equals("b"))
                return true;
            if (pattern.length() == 0)
                return value.length() == 0;
            if (value.length() == 0)
                return !(pattern.contains("a") && pattern.contains("b"));
            int aCount = 0;
            int bCount = 0;
            int valueLen = value.length();
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == 'a')
                    aCount++;
                else
                    bCount++;
            }
            int aLen = 0;
            int bLen = 0;

            if (bCount == 0 || aCount == 0) {
                int cnt = bCount > aCount ? bCount : aCount;
                int len = valueLen / cnt;
                if (valueLen % cnt != 0)
                    return false;
                else {
                    String s = value.substring(0, len);
                    for (int i = 0; i + len <= valueLen; i += len) {
                        if (!value.substring(i, i + len).equals(s))
                            return false;
                    }
                    return true;
                }
            }
            for (int i = 0; i <= valueLen; i++) {
                aLen = i;
                if ((valueLen - aLen * aCount) % bCount == 0 && (valueLen - aLen * aCount) / bCount >= 0) {
                    bLen = (valueLen - aLen * aCount) / bCount;
                    String res = "";
                    int pos = 0;
                    String a = null;
                    String b = null;
                    for (int j = 0; j < pattern.length(); j++) {
                        if (pos >= valueLen)
                            break;
                        else if (pattern.charAt(j) == 'a' && pos + aLen <= valueLen) {
                            String t1 = value.substring(pos, pos + aLen);
                            if (a == null)
                                a = t1;
                            else if (!a.equals(t1))
                                break;
                            res = res + t1;
                            pos += aLen;
                        } else if (pos + bLen <= valueLen) {
                            String t2 = value.substring(pos, pos + bLen);
                            if (b == null)
                                b = t2;
                            else if (!b.equals(t2))
                                break;
                            res = res + t2;
                            pos += bLen;
                        } else
                            break;
                    }
                    if (res.length() == valueLen && res.equals(value))
                        return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        new LeetCode16_18().new Solution().patternMatching("bb",
                "thuhrh");
    }
}
