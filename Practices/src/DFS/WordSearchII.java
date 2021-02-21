package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchII {
    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;
        public TrieNode() {};
    }

    public List<String> findWords(char[][] board, String[] words) {

        // construct Trie from words
        TrieNode root = constructTrie(words);
        List<String> result = new ArrayList<>();
        // do a dfs of board, only process when path is on Trie
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //System.out.println(board[i][j]);
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private TrieNode constructTrie(String[] words) {
        // create root
        TrieNode root = new TrieNode();
        // traverse each word in words
        for (String word: words) {
            // for current word, traverse char
            TrieNode cur = root;
            char[] array = word.toCharArray();
            for (char c: array) {
                // if cur node doesn't have cur char, add cur char to its children, update cur node
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                } else {
                    // if it has, update cur node
                    cur.children.put(c, new TrieNode());
                    cur = cur.children.get(c);
                }

            }
            cur.word = word;
            //System.out.println(word);
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {


        // base case
        if (root.word != null) {
            result.add(new String(root.word));
            root.word = null;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || !root.children.containsKey(board[i][j])) {
            return;
        }

        Character letter = board[i][j];
        //System.out.println(letter);
        TrieNode cur = root.children.get(board[i][j]);

        board[i][j] = '#';
        // generate
        for (int[] dir: DIRS) {
            dfs(board, i + dir[0], j + dir[1], cur, result);
        }
        board[i][j] = letter;

    }

    public static void main(String[] args) {
        WordSearchII s = new WordSearchII();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oathi","oathii"};
        //String[] words = {"oathii"};
        List<String> ans = s.findWords(board, words);
        System.out.println(ans);
    }
}