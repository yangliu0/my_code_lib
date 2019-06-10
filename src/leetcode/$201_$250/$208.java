package leetcode.$201_$250;

/**
 * Created by Yang Liu on 2019/5/15
 */

// Implement Trie (Prefix Tree)
public class $208 {
    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];

        TrieNode(char c) {
            this.val = c;
        }
    }

    class Trie {
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode(' ');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode(c);
                }
                p = p.children[c - 'a'];
            }
            p.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (p.children[c - 'a'] == null) {
                    return false;
                }
                p = p.children[c - 'a'];
            }
            return p.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (p.children[c - 'a'] == null) {
                    return false;
                }
                p = p.children[c - 'a'];
            }
            return true;
        }
    }
}
