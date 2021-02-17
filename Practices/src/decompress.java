public class decompress {
    public String decompress(String input) {
        // Write your solution here
        if (input == null) {
            return null;
        }
        // sanity check


        // first traverse to calculate array length
        int newLength = 0;
        int fast = 0;
        while (fast < input.length()) {
            int times = 1;
            fast++;
            while (fast < input.length() && Character.isDigit(input.charAt(fast))) {
                newLength = newLength + times * ((int) (input.charAt(fast) - '0'));
                times = times * 10;
                fast++;
            }
        }

        // second time travere to fill in result array
        char[] result = new char[newLength];
        fast = 0;
        int slow = 0;
        int digitLen = 0;
        while (fast < input.length()) {
            int freq = 0;
            if (!Character.isDigit(input.charAt(fast))) {
                fast++;
            }

            int times = 1;
            while (fast + digitLen < input.length() && Character.isDigit(input.charAt(fast + digitLen))) {
                freq = freq + times * ((int) (input.charAt(fast + digitLen) - '0'));
                times = times * 10;
                digitLen++;


                for (int i = 0; i < freq; i++) {
                    result[slow++] = input.charAt(fast - 1);
                }
                fast += digitLen;
            }
        }
        return new String(result);

    }


    public static void main(String[] args) {
        decompress s = new decompress();
        String res = s.decompress("a1b2");
        System.out.println(res);
    }
}
