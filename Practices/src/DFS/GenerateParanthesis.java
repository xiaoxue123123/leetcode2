package DFS;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    public List<String> generateParenthesis(int n) {
        /**
         dfs:
         layer: n * 2
         states: left paranthesis and right paranthesis

         2^(2n) nodes
         TC: O(2^(2n)), SC: O(2n)

         in each layer:
         numLeft < n: add left
         numRight <= numLeft: add right

         **/

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int numLeft = 0;
        int numRight = 0;
        dfs(result, sb, n, numLeft, numRight);
        return result;
    }
    private void dfs(List<String> result, StringBuilder sb, int n, int numLeft, int numRight) {
        if (numLeft == n && numRight == n) {
            result.add(sb.toString());
            return;
        }

        if (numLeft < n) {
            sb.append("(");
            dfs(result, sb, n, numLeft+1, numRight);
            sb.deleteCharAt(sb.length()-1);
        }

        if (numRight < numLeft) {
            sb.append(")");
            dfs(result, sb, n, numLeft, numRight+1);
            sb.deleteCharAt(sb.length()-1);
        }


    }
}
