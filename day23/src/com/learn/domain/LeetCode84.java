package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-30  10:38
 * @description
 */
public class LeetCode84 {
    /*    public int largestRectangleArea(int[] heights) {
            if (heights == null || heights.length == 0)
                return 0;
            int left = 0;
            int right = heights.length - 1;
            int min = left;
            int minHeight = heights[left];
            while (left <= right) {
                if (heights[left] < minHeight) {
                    min = left;
                    minHeight = heights[left];
                }
                left++;
            }
            int ans = findMaxArea(heights, 0, right, min);
            return ans;
        }

        private int findMaxArea(int[] heights, int left, int right, int min) {
            if (left == right)
                return heights[left];
            if (left > right)
                return 0;
            int area = (right - left + 1) * heights[min];
            int i = left, lmin = left, t = heights[left];
            while (i < min) {
                if (t > heights[i]) {
                    t = heights[i];
                    lmin = i;
                }
                i++;
            }
            int lArea = findMaxArea(heights, left, min - 1, lmin);
            i = right;
            int rmin = right;
            t = heights[right];
            while (i > min) {
                if (t > heights[i]) {
                    t = heights[i];
                    rmin = i;
                }
                i--;
            }
            int rArea = findMaxArea(heights, min + 1, right, rmin);
            area = area > Math.max(lArea, rArea) ? area : Math.max(lArea, rArea);
            return area;
        }*/
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int ans = 0;
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = -1;
        right[len - 1] = len;
        for (int i = 1; i < len; i++) {
            int t = i - 1;
            while (t >= 0 && heights[i] <= heights[t])
                t--;
            left[i] = t;
        }
        for (int i = len - 2; i >= 0; i--) {
            int t = i + 1;
            while (t <= len - 1 && heights[t] >= heights[i])
                t++;
            right[i] = t;
        }
        for (int i = 0; i < len; i++) {
            ans = Math.max((right[i] - left[i] - 1) * heights[i], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode84().largestRectangleArea(new int[]{6,7,5,2,4,5,9,3}));
    }
}
