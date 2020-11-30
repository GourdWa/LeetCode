import java.util.*;

/**
 * @author Zixiang Hu
 * @description 49. 字母异位词分组
 * @create 2020-09-04-14:19
 */
public class LeetCode49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chs = strs[i].toCharArray();
                Arrays.sort(chs);
                String s = new String(chs);
                if (!map.containsKey(s)) {
                    map.put(s, new ArrayList<>());
                }
                map.get(s).add(strs[i]);
            }
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        System.out.println("abc".hashCode());
        System.out.println("cab".hashCode());
    }
}
