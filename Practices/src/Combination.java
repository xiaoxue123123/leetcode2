import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> combs = new LinkedList<>();
        List<Integer> comb = new LinkedList<>();
        helper(target,coins,0,comb,combs);
        return combs;
    }

    private void helper(int target, int[] coins, int index, List comb, List combs) {
        if (index == coins.length - 1) {
            if (target % coins[index] == 0) {
                comb.add(target / coins[index]);
                combs.add(new LinkedList<>(comb));
                //comb.remove(comb.size() - 1);
            }
            return;
        }

        // max num of this coin in target
        int maxNum = target / coins[index];
        for (int i = 0; i <= maxNum; i++) {
            comb.add(i);
            helper(target - i * coins[index], coins, index + 1, comb, combs);
            comb.remove(comb.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] coins = new int[]{34,31,29,16,2};
        Combination c = new Combination();
        List<List<Integer>> answer = c.combinations(10,coins);
    }
}
