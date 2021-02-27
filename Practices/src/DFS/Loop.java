package DFS;

import java.util.HashSet;
import java.util.Set;

public class Loop {



    /**
     assumption:
     - names are strings of alphabets

     result:
     dfs:
     base case: when we have used all names,
     if last name's last letter is the same as the first name's first letter,return true
     else return false

     in each recursion:
     we will go through the names that has not been used and find the one that has first letter same as previous word's last letter
     if we can't find, return false for this recursion, if we can find, go to next level of dfs.

     n is input length
     TC: O(n!)
     SC: O(n) - because n layers in longest call stack and space of hashset

     **/

    public boolean loop(String[] names) {
        if (names == null || names.length == 0) {
            return false;
        }

        Set<String> used = new HashSet<>();

        for (int i = 0; i < names.length; i++) {
            String curWord = names[i];
            used.add(curWord);
            // if one word can have loop, return true.
            if (dfs(names, 0,used,curWord.charAt(0),curWord.charAt(curWord.length()-1))) {
                return true;
            }
            used.remove(curWord);
        }
        // if non of the word can have loop, return false
        return false;
    }

    private boolean dfs(String[] names, int numWords, Set<String> used, char firstL, char lastLOfPrev) {
        // when we used all words, and last letter of last word is same as first letter of first word, return true, else return false.
//        System.out.println("numWords " + numWords);
//        System.out.println("lastLofPrev " + lastLOfPrev);
//        System.out.println("firstL " + firstL);

        if (numWords == names.length - 1) {
            if (lastLOfPrev == firstL) {
                return true;
            } else {
                return false;
            }
        }

        // each layer can try every word that
        // 1. has not been used 2. can connect with previoss word
        for (int i = 0; i < names.length; i++) {
            if (used.contains(names[i])) {
                continue;
            }
            String curWord = names[i];
            if (curWord.charAt(0) != lastLOfPrev) {
                continue;
            }
            used.add(curWord);
            // if any of the word has a chain that can form a loop, return true
            if (dfs(names, numWords + 1, used, firstL, curWord.charAt(curWord.length()-1))) {
                return true;
            }
            used.remove(curWord);
        }
        // return false if non of the word can form a loop chain
        return false;
    }

    public static void main(String[] args) {
        Loop s = new Loop();
        Boolean ans = s.loop(new String[] {"ALICE", "CHARLES", "ERIC", "SELINA"});
        System.out.println(ans);
    }

}
