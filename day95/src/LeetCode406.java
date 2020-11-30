import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Zixiang Hu
 * @description 406. 根据身高重建队列
 * @create 2020-11-16-9:04
 */
public class LeetCode406 {
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            //先按照身高从高到低的顺序进行排序，如果身高相同，则按照k从小到大排序。例如[7,0]应该排在[7,1]的前面
            Arrays.sort(people, (o1, o2) -> {
                if (o1[0] != o2[0])
                    return o2[0] - o1[0];
                return o1[1] - o2[1];
            });
            //排序之后进行插入即可,例如排序之后{{7,0},{7,1},{6,1},{5,0},{5,2},{4,4}}
            //这样插入保证了插入位置k前面的元素刚好有k个大于等于h，且之后插入的元素由于小于h，因此不会对相对位置产生影响
            List<int[]> list = new ArrayList<>();
            for (int[] person : people) {
                list.add(person[1], person);
            }
            return list.toArray(people);
        }
    }
}
