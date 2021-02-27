package Trie;

import java.util.Arrays;

public class MaximizeXOR {

    static class Trie{
        Trie[] children = new Trie[2];
        int prefix;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        // initialize ans
        int[] ans = new int[queries.length];

        // create tmp array to sort queries and store original position
        int[][] tmp = new int[queries.length][3];

        int originalIndex = 0;
        for (int[] query: queries) {
            tmp[originalIndex][0] = query[0];
            tmp[originalIndex][1] = query[1];
            tmp[originalIndex][2] = originalIndex;
            originalIndex++;
        }

        Arrays.sort(tmp, (a, b) -> {
            return a[1] - b[1];
        });

        Arrays.sort(nums);

        Trie root = new Trie();

        int index = 0;
        // loop through tmp
        for (int[] query: tmp) {
            // insert valid num
            while (index < nums.length && nums[index] <= query[1]) {
                insert(nums[index], root);
                index++;
            }
            // greedy: search max of number close to opposite of xi
            // System.out.println(query[1]);
            int max = search(root, query[0]);
            ans[query[2]] = max;
        }
        return ans;

    }

    private void insert(int num, Trie root) {
        int index = 0;
        Trie cur = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.children[bit] == null) {
                cur.children[bit] = new Trie();
            }
            cur = cur.children[bit];
        }
        //System.out.println("nums[index] " + nums[index]);
        cur.prefix = num;
    }

    private int search(Trie root, int num) {
        Trie cur = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int find = 1 - bit;
            // System.out.println(" i " + i);
            // System.out.println("num " + num +" bit " + bit + " " + cur.children.containsKey(find));
            // System.out.println(" cur.prefix " + cur.prefix);

            if (cur.children[find] != null) {
                cur = cur.children[find];
            } else if (cur.children[bit] != null){
                cur = cur.children[bit];
            } else {
                return -1;
            }
        }
        return cur.prefix ^ num;

    }
}