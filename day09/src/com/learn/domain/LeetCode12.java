package com.learn.domain;

/**
 * @author ZixiangHu
 * @create 2020-05-16  19:50
 * @description 整数转罗马数字
 */
public class LeetCode12 {
    /* public String intToRoman(int num) {
         String[] enums = {"I", "V", "X", "L", "C", "D", "M"};
         String s = "";

         int digit;
         int pos = 0;
         while (num != 0) {
             digit = num % 10;
             num = num / 10;
             if (digit == 5)
                 s = enums[pos + 1] + s;
             else if (digit == 9)
                 s = enums[pos] + enums[pos + 2] + s;
             else if (digit == 4)
                 s = enums[pos] + enums[pos + 1] + s;
             else if (digit < 4)
                 for (int i = 0; i < digit; i++)
                     s = enums[pos] + s;
             else {
                 for (int i = 5; i < digit; i++) {
                     s = enums[pos] + s;
                 }
                 s = enums[pos + 1] + s;
             }
             pos += 2;
         }
         return s;
     }*/
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(roman[i]);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode12().intToRoman(1994));
    }
}
