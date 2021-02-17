package BFS;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
// Write your solution here
/**
 BFS:
 FIFO queue:
 next transition is current transition distance + 1
 generate all neighbors of current word, insert into FIFO queue, if neighbor is
 end word, return distance

 data structure:
 1. hashmap: store visited word and distance
 2. FIFO queue for visiting order
 **/

        Set<String> set = new HashSet<>();
        for (String s: wordList) {
            set.add(s);
        }

        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        q.offer(beginWord);
        map.put(beginWord, 1);
        while (!q.isEmpty()) {
            String cur = q.poll();
            int curDist = map.get(cur);
            StringBuilder wordModifier = new StringBuilder(cur);
            for (int i = 0; i < cur.length(); i++) {
                char origin = cur.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == origin) {
                        continue;
                    }
                    wordModifier.setCharAt(i, c);
                    String neighbor = wordModifier.toString();
                    if (set.contains(neighbor) && !map.containsKey(neighbor)) {
                        map.put(neighbor, curDist + 1);
                        q.offer(neighbor);
                    }
                    wordModifier.setCharAt(i, origin);
                }
            }
        }
        return map.getOrDefault(endWord, -1);
    }

    public static void main(String[] args) {
        //ladderLength(String beginWord, String endWord, List<String> wordList)
        //"git","hit","hog","hot"
        WordLadder s = new WordLadder();
        List<String> wordList = new ArrayList<>();
        wordList.add("git");
        wordList.add("hit");
        wordList.add("hog");
        wordList.add("hot");
        int n = s.ladderLength("git","hot",wordList);
        System.out.println(n);
    }
}
