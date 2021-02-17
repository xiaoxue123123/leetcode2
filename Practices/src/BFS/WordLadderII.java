package BFS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordLadderII {
    /**
     *  static class NeighborFinder
     *   wordIndex: hashmap to store string and integer, store index and words from input list
     *   words: list of string
     *   NeighborFinder: constructor
     *   findNeighbors: store index of visited words
     *   nested static class Tracer:
     *     - fields: List<String> words, List<List<Integer>> preds;
     *     - methods:
     *       - constructor
     *       - addPredecessor: add index x of predecessor of word of index y
     *       - findLadders:
     *       - findLaddersHelper: DFS to add all path from beginIndex to endIndex to result
     *
     *   findLadders (main function):
     *      - BFS
     *
     *
     *
     * **/


    static class NeighborFinder {
        // store String and its corresponding index from input String list
        private Map<String, Integer> wordIndex = new HashMap<>();
        // input String list
        private List<String> words;

        // constructor

        /**
         * find neighbors:
         * input: index i of the word we want to find neighbors for
         * output: a list of index of neighbors of this word
         * **/

    }

    static class Tracer {
        private List<String> words;
        // list of predecessors of words at index i
        private List<List<Integer>> preds;

        // constructor


        // add word at index x to the predecessor list of word at index y
        public void addPredecessor(int x, int y) {

        }

        //
        public List<List<String>> findLadders(int beginIndex, int y) {
            return null;
        }

        // trace is like current string builder
        // when trace reaches y, add trace to ladders
        private void findLaddersHelper(int beginIndex, int y, List<String> tracer, List<List<String>> ladders) {

        }
    }

    // use BFS to find predecessors
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        return null;
    }
}
