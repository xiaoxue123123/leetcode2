package Trie;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {


    class Trie {

        private Map<Character, Trie> children;
        private String word;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            children = new HashMap<>();
            word = null;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children.containsKey(word.charAt(i))) {
                    cur = cur.children.get(word.charAt(i));
                } else {
                    Trie newNode = new Trie();
                    cur.children.put(word.charAt(i), newNode);
                    cur = newNode;
                }
            }
            cur.word = word;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie cur = this;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children.containsKey(word.charAt(i))) {
                    cur = cur.children.get(word.charAt(i));
                } else {
                    return false;
                }
            }
            return cur.word != null;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie cur = this;
            for (int i = 0; i < prefix.length(); i++) {
                if (cur.children.containsKey(prefix.charAt(i))) {
                    cur = cur.children.get(prefix.charAt(i));
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */