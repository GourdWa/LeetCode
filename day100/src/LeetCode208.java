/**
 * @author Zixiang Hu
 * @description 208. 实现 Trie (前缀树)
 * @create 2020-12-01-19:50
 */
public class LeetCode208 {
    class TreeNode {
        private TreeNode[] link;
        private int N = 26;
        private boolean isEnd;

        public TreeNode() {
            this.link = new TreeNode[N];
        }

        public boolean containsKey(char ch) {
            return link[ch - 'a'] != null;
        }

        public void put(char ch, TreeNode node) {
            link[ch - 'a'] = node;
        }

        public TreeNode get(char ch) {
            return link[ch - 'a'];
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {
        private TreeNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TreeNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.containsKey(c)) {
                    node.put(c, new TreeNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.containsKey(c)) {
                    node = node.get(c);
                } else
                    return false;
            }
            return node.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TreeNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.containsKey(c)) {
                    node = node.get(c);
                } else
                    return false;
            }
            return true;
        }
    }
}
