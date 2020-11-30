import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 1002. 查找常用字符
 * @create 2020-10-14-8:56
 */
public class LeetCode1002 {
    static class Solution {
        public List<String> commonChars(String[] A) {
            int[][] arr = new int[A.length][26];
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length(); j++) {
                    arr[i][A[i].charAt(j) - 'a']++;
                }
            }
            for (int i = 0; i < 26; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < arr.length; j++) {
                    min = Math.min(min, arr[j][i]);
                }
                while (min-- > 0)
                    list.add(String.valueOf((char) ('a' + i)));
            }
            return list;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().commonChars(new String[]{"bella","label","roller"}));
    }
}
