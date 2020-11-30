/**
 * @author Zixiang Hu
 * @description 547. 朋友圈
 * @create 2020-08-11-10:04
 */
public class LeetCode547 {


    class Solution {
        class UnionFind {
            private int count;
            private int[] leader;
            private int[] size;

            public UnionFind(int count) {
                this.count = count;
                leader = new int[count];
                size = new int[count];
                for (int i = 0; i < count; i++) {
                    //起初权重都是1，各自一派
                    leader[i] = i;
                    size[i] = 1;
                }
            }

            /**
             * 查找一个节点的领导
             *
             * @param q
             * @return
             */
            public int find(int q) {
                //如果自己的领导不是自己，则继续查找上层领导
                while (q != leader[q]) {
                    //当前节点的领导变为其领导的领导
                    leader[q] = leader[leader[q]];
                    q = leader[q];
                }
                //返回真正的领导
                return q;
            }

            /**
             * 合并两个团体
             *
             * @param p
             * @param q
             */
            public void union(int p, int q) {
                //首先找到这两个的真正领导
                int pLeader = find(p);
                int qLeader = find(q);
                //如果它们不是同一个领导则合并
                if (pLeader != qLeader) {
                    //谁领导的人多，谁就是新的领导
                    if (size[pLeader] > size[qLeader]) {
                        leader[qLeader] = pLeader;
                        size[pLeader] += size[qLeader];
                    } else {
                        leader[pLeader] = qLeader;
                        size[qLeader] += size[pLeader];
                    }
                    //合并之后，团体的数量减少
                    count--;
                }
            }

            /**
             * 判断两个人是否是同一个团队的
             *
             * @param p
             * @param q
             * @return
             */
            public boolean connected(int p, int q) {
                return find(p) == find(q);
            }

            /**
             * 返回团体的数量
             *
             * @return
             */
            public int getCount() {
                return count;
            }
        }

        public int findCircleNum(int[][] M) {
            int ans = 0;
            int len = M.length;
            UnionFind unionFind = new UnionFind(len);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (M[i][j] == 1)
                        unionFind.union(i, j);
                }
            }
            ans = unionFind.getCount();
            return ans;
        }
    }
}
