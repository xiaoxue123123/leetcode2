package String;

import java.util.List;
import java.util.ArrayList;

public class PalindromePatition {

    public List<List<String>> partition(String s) {
        /**

         a a b
         /       \
         a         ""
         /.   \
         aa.      a|a
         / \      /    \
         aa|b aab  a|a|b a|ab


         **/
        List<List<String>> result = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dfs(result, cur, 0, s);
        return result;

    }

    private void dfs(List<List<String>> result, List<String> cur, int index, String s) {
        // base case
        if (index == s.length()) {
            result.add(new ArrayList<String>(cur));
            return;
        }

        for (int end = index; end < s.length(); end++) {
            if (isPalindrome(s,index, end)) {
                cur.add(s.substring(index, end + 1));
                dfs(result, cur, end + 1, s);
                cur.remove(cur.size() - 1);
            }
        }
    }


    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

}