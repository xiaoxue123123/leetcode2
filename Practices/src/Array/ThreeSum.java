package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= array.length - 3; i++) {
            if (i > 0 && array[i] == array[i-1]) {
                continue;
            }
            List<List<Integer>> complement = twoSum(array, target - array[i], i+1);
            for (int j = 0; j < complement.size(); j++) {
                List<Integer> cur = new ArrayList<>();
                cur.add(complement.get(j).get(0));
                cur.add(complement.get(j).get(1));
                cur.add(array[i]);
                result.add(cur);
            }
        }
        return result;

    }

    private List<List<Integer>> twoSum(int[] array, int target, int lo) {
        List<List<Integer>> result = new ArrayList<>();
        int hi = array.length - 1;
        int loPtr = lo;
        while (loPtr < hi) {
            if (loPtr > lo && array[loPtr] == array[loPtr - 1]) {
                loPtr++;
                continue;
            }

            int sum = array[loPtr] + array[hi];
            if (sum == target) {
                List<Integer> cur = new ArrayList<>();
                cur.add(array[loPtr]);
                cur.add(array[hi]);
                result.add(cur);
                loPtr++;
                hi--;
            } else if (sum < target) {
                loPtr++;
            } else {
                hi--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
        List<List<Integer>> result = s.allTriples(new int[]{3,4,0,-1,2,0,5}, 10);
        System.out.println(result);
    }
}
