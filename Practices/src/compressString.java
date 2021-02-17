public class compressString {
    public String compress(String input) {
        // sanity check
        if (input == null) {
            return null;
        }

        // convert string to array
        char[] inputArray = input.toCharArray();
        // step 1 traverse
        int fast = 0;
        int slow = 0;
        int countOne = 0;
        int newLength = 0;
        while (fast < inputArray.length) {
            char curChar = inputArray[fast];
            int freq = 0;
            while (fast + freq < inputArray.length && curChar == inputArray[fast+freq]) {
                freq++;
            }
            fast = fast + freq;
            inputArray[slow++] = curChar;

            if (freq > 1) {
                int len = copyDigits(inputArray,slow,freq);
                slow = slow + len;
                newLength += len + 1;
            } else {
                countOne++;
                newLength += 2;
            }

        }
        System.out.println(new String(inputArray));
        // second traverse
        char[] result = new char[newLength];
        fast = slow- 1;
        slow = newLength - 1;
        while (fast >= 0) {
            if (Character.isDigit(inputArray[fast])){
                while (fast >= 0 && Character.isDigit(inputArray[fast])) {
                    result[slow--] = inputArray[fast--];
                }
            } else {
                result[slow--] = '1';
            }
            result[slow--] = inputArray[fast--];
        }



        // return
        return new String(result);

    }
    private int copyDigits(char[] input, int index, int freq) {
        int len = 0;
        // find the last position to put freq in input
        for (int i = freq; i > 0; i /= 10) {
            index++;
            len++;
        }
        // write freq in input from the most right digit
        for (int i = freq; i > 0; i /= 10) {
            int digit = i % 10;
            input[--index] = (char)('0' + digit);
        }
        return len;
    }

    public static void main(String[] args) {
        compressString s = new compressString();
        String res = s.compress("nnnnffffffffff");
        System.out.println(res);
    }
}
