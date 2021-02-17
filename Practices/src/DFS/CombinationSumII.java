package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // Write your solution here

        /**
         dfs: num.length layers, 2 states each node, 2^num.length

         **/
        if (num == null || num.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(num);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        dfs(result, curList, 0, num, target);

        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> curList, int index, int[] num, int target){
        if (index == num.length || target <= 0) {
            if (target == 0) {
                result.add(new ArrayList(curList));
            }
            return;
        }

        for (int i = index; i < num.length;i++) {
            if (i >= 1 && num[i] == num[i-1]) {
                continue;
            }
            curList.add(num[i]);
            // use cur candidate
            dfs(result, curList, i + 1, num, target - num[i]);
            curList.remove(curList.size() - 1);
        }


    }

    public static void main(String[] args) {
        CombinationSumII s = new CombinationSumII();
        List<List<Integer>> ans = s.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(ans);
    }
}
