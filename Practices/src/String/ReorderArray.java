package String;

import java.util.ArrayList;
import java.util.List;

public class ReorderArray {

        public String replace(String input, String pattern1, String pattern2) {
            // sanity check
            if (input == null || pattern1 == null || pattern2 == null || pattern1.length() >= input.length()) {
                return input;
            }
            // store the first index of p1
            List<Integer> matches = new ArrayList<>();
            int fast = 0;
            while (fast < input.length()) {
                if (match(input, pattern1, fast)) {
                    matches.add(fast);
                    fast += pattern1.length();
                } else {
                    fast++;
                }
            }
            // create a placeholder for output
            char[] result = new char[input.length() + (pattern2.length() - pattern1.length()) * matches.size()];
            // scan input and replace
            int slow = 0;
            int idxMatch = 0;
            fast = 0;
            while (slow < result.length && fast < input.length()) {
                if (idxMatch < matches.size() && fast == matches.get(idxMatch)) {
                    // copy pattern2
                    int k = 0;
                    while (k < pattern2.length()) {
                        result[slow + k] = pattern2.charAt(k);
                        k++;
                    }
                    slow = slow + k;
                    fast = fast + pattern1.length();
                    idxMatch++;
                } else {
                    // copy from input
                    result[slow++] = input.charAt(fast++);
                }
            }
            System.out.println(matches);
            return new String(result);
        }

        private boolean match(String input, String pattern1, int idx) {
            for (int i = 0; i < pattern1.length(); i++) {
                if (idx + i < input.length() && input.charAt(idx + i) != pattern1.charAt(i)){
                    return false;
                }
            }
            return true;
        }


    public static void main(String[] args) {
        ReorderArray s = new ReorderArray();
        String input = "sgojkmxquqhvmagmrmxquqhvmagmrejjkhhquqhvmagmrnhquqhvmagmraslreywpzquqhvmagmrhnjjssczquqhvmagmrypiimbgquqhvmagmrvitlquqhvmagmrlqcquqhvmagmrypiimbgquqhvmagmrztydquqhvmagmrypiimbgquqhvmagmrxwapquqhvmagmrdkbhcdvpq";
        String pattern1 = "quqhvmagmr";
        String pattern2 = "ypiimbg";
        s.replace(input,pattern1,pattern2);
    }

}
