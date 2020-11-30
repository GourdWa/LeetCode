import java.util.ArrayList;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 233. 数字 1 的个数
 * @create 2020-10-25-14:30
 */
public class LeetCode233 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("JavaScript");
        list.add("Python");
        System.out.println(list.stream().filter((s) -> s.equals("Java")).count());
    }
}
