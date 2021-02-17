package String;


import java.util.Arrays;

public class Decompress {
    public String decompress(String input) {

        char[] array = input.toCharArray();
        // linear scan and find right length
        int len = 0;

        int ptr = 0;
        int curNum = 0;
        while (ptr < input.length()){
            if (Character.isDigit(array[ptr])) {
                curNum = array[ptr] - '0';
                ptr++;
                while (ptr < input.length() && Character.isDigit(array[ptr])) {
                    curNum = curNum * 10 + array[ptr] - '0';
                    ptr++;
                }
                len += curNum;
            }
            ptr++;
        }

        char[] result = new char[len];

        // decompress
        ptr = 0;
        int ptrRes = 0;
        char c = 'a';
        while (ptr < input.length()) {
            if (input.charAt(ptr) >= 'a' && input.charAt(ptr) <= 'z') {
                c = input.charAt(ptr);
                ptr++;
            } else {
                curNum = 0;
                while (ptr < input.length() && Character.isDigit(array[ptr])) {
                    curNum = curNum * 10 + array[ptr] - '0';
                    ptr++;
                }

                for (int i = 0; i < curNum; i++) {
                    result[ptrRes + i] = c;
                }
                ptrRes += curNum;

            }
        }
        return Arrays.toString(result);


    }

    public static void main(String[] args) {
        Decompress s = new Decompress();
        String ans = s.decompress("x2");
        System.out.println(ans);
    }

}
