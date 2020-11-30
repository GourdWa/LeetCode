import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 17. 电话号码的字母组合
 * @create 2020-08-26-8:47
 */
public class LeetCode17 {
    static class Solution {
        List<String> list = new ArrayList<>();
        String[] strings = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            if (digits.length() != 0)
                dfs(digits.toString(), 0, new StringBuilder());
            return list;
        }

        private void dfs(String digits, int i, StringBuilder stringBuilder) {
            if (stringBuilder.length() == digits.length()) {
                list.add(new String(stringBuilder));
                return;
            }
            for (int j = i; j < digits.length(); j++) {
                int n = digits.charAt(j) - '0' - 2;
                String str = strings[n];
                for (int k = 0; k < str.length(); k++) {
                    stringBuilder.append(str.charAt(k));
                    // 注意，这里是j+1，并非i+1
                    dfs(digits, j + 1, stringBuilder);
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("233"));
    }
}
