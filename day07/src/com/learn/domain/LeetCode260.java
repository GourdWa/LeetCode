package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-14  9:58
 * @description
 */
public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int xnor = 0;
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            xnor ^= num;
        }
        int bit = 1;
        //找出从左到右位数上的第一个1
        while ((bit & xnor) == 0) {
            bit = bit << 1;
        }
        for (int num : nums) {
            if ((bit & num) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        new LeetCode260().singleNumber(new int[]{1,2,1,3,2,5});
    }
}
