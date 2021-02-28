package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {


    static class Trie {
        Trie[] children = new Trie[26];
        List<Integer> palindromePrefixRemaining = new ArrayList<>();
        int isEnd = -1;
    }

    private boolean hasPalindromeRemaining(String s, int i) {
        int p1 = i;
        int p2 = s.length() - 1;
        while (p1 < p2) {
            if (s.charAt(p1++) != s.charAt(p2--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        // build trie
        Trie root = new Trie();
        for (int wordId = 0; wordId < words.length; wordId++) {
            String word = words[wordId];
            String reversedWord = new StringBuilder(word).reverse().toString();
            Trie cur = root;
            for (int j = 0; j < word.length(); j++) {
                if (hasPalindromeRemaining(reversedWord, j)) {
                    cur.palindromePrefixRemaining.add(wordId);
                }
                char c = reversedWord.charAt(j);
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Trie();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isEnd = wordId;
        }

        // search word
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie cur = root;
            for (int j = 0; j < word.length(); j++) {
                // case 3
                if (cur.isEnd != -1 && hasPalindromeRemaining(word, j)) {
                    ans.add(Arrays.asList(i, cur.isEnd));
                }
                char c = word.charAt(j);
                cur = cur.children[c - 'a'];
                if (cur == null) {
                    break;
                }
            }
            if (cur == null) {
                continue;
            }
            // case 1, word 已经走完了
            if (cur.isEnd != -1 && cur.isEnd != i) {
                ans.add(Arrays.asList(i, cur.isEnd));
            }

            // case2, word 走完 cur 还没走完
            for (int other: cur.palindromePrefixRemaining) {
                ans.add(Arrays.asList(i, other));
            }

        }
        return ans;
    }


}