package Bit;

import java.util.HashSet;
import java.util.Set;

public class FindMaximunXOR {
    public int findMaximumXOR(int[] nums) {

        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            Set<Integer> set = new HashSet<>();
            // greedy algorithm: check if a ^ b = c where c is number with the largest position as 1
            // if so, set it as largest. next iteration, add 1 to second largest position
            mask = mask | (1 << i);

            // only check digit on i-th position
            for (int num: nums) {
                set.add(mask & num);
            }

            // generate next largest number
            int tmp = res | (1 << i);
            for (int prefix: set) {
                // if tmp ^ prefix in set, it means two numbers XOR is equal to current largest number
                // it means two number can generate 1 on ith position
                if (set.contains(tmp ^ prefix)) {
                    res = tmp;
                    break;
                }
            }


        }
        return res;
    }
}
