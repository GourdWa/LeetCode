import javax.sound.midi.Soundbank;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Zixiang Hu
 * @description 295. 数据流的中位数
 * @create 2020-10-18-14:48
 */
public class LeetCode295 {
    //超时
/*    class MedianFinder {
        private LinkedList<Integer> arrays = new LinkedList<>();
        */

    /**
     * initialize your data structure here.
     *//*
        public MedianFinder() {

        }

        public void addNum(int num) {
            if (arrays.size() == 0)
                arrays.add(num);
            else {
                int i;
                for (i = 0; i < arrays.size(); i++) {
                    if (num < arrays.get(i))
                        break;
                }
                if (i == arrays.size()) {
                    arrays.add(num);
                } else {
                    arrays.add(i, num);
                }
            }
        }

        public double findMedian() {
            int size = arrays.size();
            if (size % 2 == 1)
                return arrays.get(size / 2) * 1.0;
            else
                return (arrays.get(size / 2) + arrays.get(size / 2 - 1)) / 2.0;
        }
    }*/
    class MedianFinder {
        //左边用最大堆；右边用最小堆
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        private int size = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            //如果是偶数个，添加到最小堆
            if (size % 2 == 0) {
                minHeap.add(num);
                Integer pollMin = minHeap.poll();
                maxHeap.add(pollMin);
                Integer pollMax = maxHeap.poll();
                minHeap.add(pollMax);
            } else {
                maxHeap.add(num);
                Integer pollMax = maxHeap.poll();
                minHeap.add(pollMax);
                Integer pollMin = minHeap.poll();
                maxHeap.add(pollMin);
            }
            size++;
        }

        public double findMedian() {
            if (size % 2 == 0)
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            else {
                return minHeap.peek();
            }
        }
    }

    public static void main(String[] args) {

    }
}
