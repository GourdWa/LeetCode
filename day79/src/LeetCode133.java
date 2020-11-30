import java.util.*;

/**
 * @author Zixiang Hu
 * @description 133. 克隆图
 * @create 2020-09-07-16:55
 */
public class LeetCode133 {
    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null)
                return null;
            HashMap<Node, Node> map = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();
            map.put(node, new Node(node.val));
            queue.add(node);
            while (!queue.isEmpty()) {
                Node pollNode = queue.poll();
                if (!map.containsKey(pollNode))
                    map.put(pollNode, new Node(pollNode.val));
                List<Node> neighbors = pollNode.neighbors;
                for (Node neighbor : neighbors) {
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, new Node(neighbor.val));
                        queue.add(neighbor);
                    }
                    map.get(pollNode).neighbors.add(map.get(neighbor));
                }
            }
            return map.get(node);
        }
    }
}
