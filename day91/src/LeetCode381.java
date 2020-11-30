import java.util.*;

/**
 * @author Zixiang Hu
 * @description 381. O(1) 时间插入、删除和获取随机元素 - 允许重复
 * @create 2020-10-31-20:04
 */
public class LeetCode381 {
    class RandomizedCollection {
        int n;//当前集合大小
        HashMap<Integer, Set<Integer>> map;
        ArrayList<Integer> list;
        Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            this.random = new Random();
            this.map = new HashMap();
            this.n = 0;
            this.list = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            Set set = map.get(val);
            if (set == null) set = new HashSet<>();
            set.add(n);//添加索引
            list.add(val);
            map.put(val, set);
            n++;
            return set.size() == 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int lastIndex = n - 1;//得到最后的索引
                //得到最后一个值对应的Set集合
                Set lastset = map.get(list.get(lastIndex));
                Set set = map.get(val);
                int currIndex = (int) set.iterator().next();//得到当前值索引
                //进行删除操作
                swap(list, currIndex, lastIndex);
                list.remove(n - 1);//将其在列表中删除
                set.remove(currIndex);//删除原值
                if (set.size() == 0) map.remove(val);//在图中删除
                //修改最后一个值的索引
                lastset.remove(n - 1);
                lastset.add(currIndex);
                n--;
            } else {
                return false;
            }
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get(random.nextInt(n));
        }

        private void swap(List<Integer> list, int i, int j) {
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public static void main(String[] args) {

    }
}
