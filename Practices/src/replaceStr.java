import java.util.ArrayList;
import java.util.Arrays;

public class replaceStr {
    public String replace(String input, String pattern1, String pattern2) {
        // sanity check
        if (input == null || pattern1 == null || pattern2 == null) {
            return input;
        }

        // find # of pattern1
        char[] array = input.toCharArray();
        ArrayList<Integer> matches = strstr(array, pattern1);





        return new String(replaceArray(array, pattern1, pattern2, matches));
        // return


    }

    private ArrayList<Integer> strstr(char[] array, String pattern1) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        while (i <= array.length - pattern1.length()) {
            if (equalsSubstring(array,i,pattern1)) {
                result.add(i + pattern1.length() - 1);
                i += pattern1.length();
            } else {
                i++;
            }
        }
        return result;
    }

    private boolean equalsSubstring(char[] array, int fromIndex, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (array[fromIndex + i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }



    private char[] replaceArray(char[] array, String pattern1, String pattern2, ArrayList<Integer> matches) {

        char[] result = new char[matches.size() * (pattern2.length() - pattern1.length()) + array.length];
        int fast = array.length - 1;
        int match = matches.size() - 1;
        // copy in place and update
        int i = result.length - 1;;
        while (fast >= 0) {
// if matches
            if (match >=0 && fast == matches.get(match)) {
                int j = 0;
                while (pattern2.length() - 1 - j >= 0) {
                    result[i] = pattern2.charAt(pattern2.length() - 1 - j);
                    j++;
                    i--;
                }
                match--;
                fast = fast - pattern1.length();
            } else {
                result[i--] = array[fast--];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        replaceStr ans = new replaceStr();
//        char[] array = "flower_shop_at".toCharArray();
//        int freq = ans.strstr(array, "_");
//        array = ans.arraySizeUp(array,"_","20%",2);
        String result = ans.replace("zitslfzqbozmxzmxzzedrnrozkflzbkzpmqszmxzehtzmlezhkgplwpyyzmxzcpubqxdijzmxzzxhyzupblsuua", "z", "mx");
//        String result = ans.replace("flower_shop_at","_","20%");
        System.out.println(result);
    }

}
