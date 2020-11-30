package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-15  17:52
 * @description LeetCode11 装水最多的容器
 */
public class LeetCode11 {
    //暴力
/*    public int maxArea(int[] height) {
        int maxVol = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int tempVol = Math.min(height[i], height[j]) * (j - i);
                if (tempVol > maxVol)
                    maxVol = tempVol;
            }
        }
        return maxVol;
    }*/

    public int maxArea(int[] height) {
        int maxVol = 0;
        int width = 0;
        int minHeight;
        for (int i = 0, j = height.length - 1; i < j; ) {
            width = j - i;
            minHeight = Math.min(height[i], height[j]);
            if (height[i] > height[j]) {
                maxVol = maxVol > width * height[j] ? maxVol : width * height[j];
                //j递减
                while (i < j && height[j] <= minHeight) {
                    j--;
                }
            } else {
                maxVol = maxVol > width * height[i] ? maxVol : width * height[i];
                while (i < j && height[i] <= minHeight) {
                    i++;
                }
            }
        }
        return maxVol;
    }

    public static void main(String[] args) {

    }
}
