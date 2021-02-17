import java.util.Arrays;

public class ArrayDeduplication {
    public int[] dedup(int[] array) {
        int end = -1;
        for (int i = 0; i < array.length; i++) {
//        int i = 0;
//        while (i < array.length) {
            if (end == -1 || array[end] != array[i]) {
                array[++end] = array[i];
            } else {
                while (i + 1 < array.length && array[i + 1] == array[end]) {
                    i++;
                }
                end--;
            }
        }
        return Arrays.copyOf(array, end + 1);
    }
    public static void main(String[] arrays) {
        ArrayDeduplication s = new ArrayDeduplication();
        int[] result = s.dedup(new int[]{1,1,2,3,3,3,2,1,6});
        System.out.println(Arrays.toString(result));
 
    }
}
