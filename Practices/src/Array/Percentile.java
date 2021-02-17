package Array;
import java.util.ArrayList;
import java.util.List;

public class Percentile {
    public int percentile95(List<Integer> lengths) {
        int[] count = new int[10];
        for (int len: lengths) {
            count[len] = count[len] + 1; // 每个count都是1
        }
        int sum = 0;
        int len = 10;
        while (sum <= 0.5 * lengths.size()) {
            // count lengths size的5%
            sum = sum + count[--len]; // return after --
        }
        return len;
    }
    public static void main(String[] args) {
        Percentile s = new Percentile();
        List<Integer> length = new ArrayList<>();
        for (int i = 5; i >= 0; i--) {
            length.add(i);
        }
        System.out.println(s.percentile95(length));
    }
}
