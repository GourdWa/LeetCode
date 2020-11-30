import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 336. 回文对
 * @create 2020-08-06-8:41
 */
public class LeetCode336 {
    static class Solution {
        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> lists = new ArrayList<>();
            if (words.length > 0) {
                for (int i = 0; i < words.length; i++) {
                    for (int j = 0; j < words.length; j++) {
                        if (i != j && isPalindrome(words[i] + words[j])) {
                            lists.add(Arrays.asList(i, j));
                        }
                    }
                }
            }
            return lists;
        }

        public boolean isPalindrome(String str) {
            int left = 0, right = str.length() - 1;
            while (right > left) {
                if (str.charAt(right--) != str.charAt(left++))
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String a = "123";
        String a1 = "123";
        String b = a + 2;//但是如果你使b="123"+2，那么b==c
        String e = a1 + 2;
        String c = "1232";
        String d = new String("1232");
        String c2 = "1232";
        //相等，因为都是从常量池中取
        System.out.println("a == a1:" + (a == a1));
        //不等，都是new
        System.out.println("b == e:" + (b == e));
        //不等，一个是常量池中拿，一个new；但是如果a使用final修饰，就是都拿的常量池的内容；相当于"1234"==("12"+"34")是true一样
        System.out.println("b == c:" + (b == c));
        //不等，一个是常量池中拿，一个new
        System.out.println("e == c:" + (e == c));
        //不等，一个是常量池中拿，一个new
        System.out.println("d == c:" + (d == c));
        //相等，都是从常量池中取
        System.out.println("c2 == c:" + (c2 == c));

        System.out.println("1234"==("12"+"34"));
    }
}
