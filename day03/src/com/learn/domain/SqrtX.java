package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-09  16:49
 * @description
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int high = x / 2;
        int low = 1;
        int mid = 0;
        while (high >= low) {
            mid = low + (high - low) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))
                break;
            else if (mid <= x / mid)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(2147395600));
    }
}
