package DFS;

import java.util.ArrayList;
import java.util.List;

public class GeneralAbbreviation {

    /**
     every word can be 1 or itself
     it is a combination problem

     word
     /     \
     1      w
     / \    /. \
     2  1o  w1   wo
     /\
     3 2r
     ....

     TC: O(2^length)
     SC: O(length)

     **/
    public List<String> generateAbbreviations(String word) {

        if (word == null) {
            return null;
        }
        List<String> result = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        dfs(result, cur, 0,0, word);
        return result;

    }
    private void dfs(List<String> result, StringBuilder cur, int i, int j, String word) {
        int prevLen = cur.length();
        // base case
        if (i == word.length()) {
            if (j > 0) {
                cur.append(j);
            }
            result.add(cur.toString());
        } else {
            // convert to number
            dfs(result, cur, i + 1, j+1, word);



            // keep original character
            if (j > 0) {
                cur.append(j);
            }
            cur.append(word.charAt(i));
            dfs(result, cur, i + 1, 0, word);
        }
        cur.setLength(prevLen);



    }


}














