import java.util.Arrays;
import java.util.Random;

/**
 * @author Zixiang Hu
 * @description 堆排序
 * @create 2020-06-30-14:44
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHead(arr, i, len);
        }
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHead(arr, 0, i);
        }
    }

    public static void adjustHead(int[] arr, int n, int len) {
        int temp = arr[n];
        for (int i = 2 * n + 1; i < len; i++) {
            if (i + 1 < len && arr[i] < arr[i + 1])
                i += 1;
            //如果根节点大于最大的子节点那么就退出
            if (temp > arr[i])
                break;
            arr[n] = arr[i];
            n = i;
        }
        arr[n] = temp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
