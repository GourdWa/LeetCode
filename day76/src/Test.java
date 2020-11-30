/**
 * @author Zixiang Hu
 * @description
 * @create 2020-08-29-10:01
 */
public class Test {
   static class Solution {
        public int solve(String[] points) {
            double centerX, centerY;
            double distance = Double.MAX_VALUE;
            int ans = 0;
            int sumX = 0, sumY = 0;
            for (String point : points) {
                sumX += point.charAt(0) - '0';
                sumY += point.charAt(2) - '0';
            }
            centerX = (sumX * 1.0) / points.length;
            centerY = (sumY * 1.0) / points.length;
            for (int i = 0; i < points.length; i++) {
                double tempDis = Math.sqrt(Math.pow(points[i].charAt(0) - '0' - centerX, 2) + Math.pow(points[i].charAt(2) - '0' - centerY, 2));
                if (tempDis < distance) {
                    distance = tempDis;
                    ans = i;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve(new String[]{"1,1", "2,2", "1,2", "1,3"}));
    }
}
