/**
 * @author Zixiang Hu
 * @description 201. 数字范围按位与
 * @create 2020-08-23-17:05
 */
public class LeetCode201 {
    class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int shiftBit = 0;
            while (n > m) {
                n >>= 1;
                m >>= 1;
                shiftBit++;
            }
            return m << shiftBit;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
