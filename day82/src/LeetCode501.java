import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 * @author Zixiang Hu
 * @description 501. 二叉搜索树中的众数
 * @create 2020-09-24-8:33
 */
public class LeetCode501 {
    class Solution {
        private int maxTime = 0;
        private int currentTime = 1;
        Integer preVal;
        private ArrayList<Integer> res = new ArrayList<Integer>();

        private void inOder(TreeNode root) {
            if (root != null) {
                inOder(root.left);
                if (preVal != null) {
                    currentTime = (root.val == preVal) ? (currentTime + 1) : 1;
                }
                if (currentTime >= maxTime) {
                    if (currentTime > maxTime) {
                        res.clear();
                        maxTime = currentTime;
                    }
                    res.add(root.val);
                }
                preVal = root.val;
                inOder(root.right);
            }
        }

        public int[] findMode(TreeNode root) {
            inOder(root);
            int[] r = new int[res.size()];
            Iterator it = res.iterator();
            int i = 0;
            while (it.hasNext()) {
                r[i] = (int) it.next();
                i++;
            }
            return r;
        }
    }

    public static void main(String[] args) {

    }
}
