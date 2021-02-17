package String;


/**
 * How to deal with corner case when converting from char to int?
 * case 1: trim leading 0
 * case 2: take the closest sign to numeric char. ex. +-123 => -123, -+123 => 123
 * case 3: only count numeric before invalid char. ex. -12a3 => -12
 * save result as long type, if bigger or smaller than MAX_VALUE or MIN_VALUE, return.
 * **/
public class Atoi {
    public int atoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int n = str.length();
        int i = 0;
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        boolean positive = true;
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            positive = (str.charAt(i) == '+');
            i++;
        }
        long sum = 0;
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            sum = sum * 10 + (str.charAt(i) - '0');
            if (positive && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (!positive && -sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        sum = positive ? sum : -sum;
        return (int) sum;
    }
}
