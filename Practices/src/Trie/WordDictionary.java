package Trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {


    private Trie root;

    static class Trie{
        Map<Character, Trie> children;
        String word;
        Trie() {
            children = new HashMap<>();
            word = null;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie cur = root;
        if (search(word)) {
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            Trie nextChar = cur.children.get(word.charAt(i));
            if (nextChar == null) {
                nextChar = new Trie();
                cur.children.put(word.charAt(i), nextChar);
                cur = nextChar;
            } else {
                cur = nextChar;
            }
        }
        cur.word = word;
    }

    public boolean search(String word) {

        char[] array = word.toCharArray();
        return searchHelper(array, root, 0);
    }

    private boolean searchHelper(char[] array, Trie root, int start) {
        // if (root == null) {
        //     return true;
        // }
        // if (start == array.length && root.children.size() == 0) {
        //     return true;
        // }
        Trie cur = root;
        for (int i = start; i < array.length; i++) {
            Trie nextChar = cur.children.get(array[i]);
            if (array[i] == '.') {
                for (char newChar: cur.children.keySet()) {
                    Trie newRoot = cur.children.get(newChar);
                    if (searchHelper(array, newRoot, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else if (nextChar == null) {
                return false;
            } else {
                cur = nextChar;
            }
        }
        return cur.word == null ? false : true;

    }


}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */