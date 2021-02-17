import java.util.ArrayList;
import java.util.List;

public class Nqueens {
    public List<List<Integer>> nqueensII(int n) {

        // initialize array for used:
        // 2. columns
        boolean[] usedCol = new boolean[n];
        // 3. diagonals
        boolean[] usedDiagonal = new boolean[2 * n - 1];
        // 4. reverse diagonals
        boolean[] revUsedDiagonal = new boolean[2 * n - 1];
        // initialize result
        List<List<Integer>> result = new ArrayList<>();
        // initialize cur
        int[] cur = new int[n];
        // call helper
        helper(n, 0, cur, result, usedCol, usedDiagonal, revUsedDiagonal);
        // return
        return result;
    }

    private void helper(int n, int row, int[] cur, List<List<Integer>> result, boolean[] usedCol, boolean[] usedDiagonal, boolean[] revUsedDiagonal) {
        // base case
        if (row == n) {
            result.add(toList(cur));
            return;
        }
        // iterate each state
        for (int i = 0; i < n; i++) {
            // if valid
            if (valid(n, row, i, usedCol, usedDiagonal, revUsedDiagonal)) {
                // 1. add state
                cur[row] = i;
                // 2. mark state
                mark(n, row, i, usedCol, usedDiagonal, revUsedDiagonal);
                // go deeper
                helper(n, row + 1, cur, result, usedCol, usedDiagonal, revUsedDiagonal);
                // unMark state
                unMark(n, row, i, usedCol, usedDiagonal, revUsedDiagonal);

            }
        }

    }

    private boolean valid(int n, int row, int col, boolean[] usedCol, boolean[] usedDiagonal, boolean[] revUsedDiagonal) {
        return !usedCol[col] && !usedDiagonal[col + row] && !revUsedDiagonal[col - row + n - 1];
    }

    private void mark(int n, int row, int col, boolean[] usedCol, boolean[] usedDiagonal, boolean[] revUsedDiagonal) {
        usedCol[col] = true;
        usedDiagonal[col + row] = true;
        revUsedDiagonal[col - row + n - 1] = true;
    }

    private void unMark(int n, int row, int col, boolean[] usedCol, boolean[] usedDiagonal, boolean[] revUsedDiagonal) {
        usedCol[col] = false;
        usedDiagonal[col + row] = false;
        revUsedDiagonal[col - row + n - 1] = false;
    }

    private List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int n: array) {
            list.add(n);
        }
        return list;
    }

    public static void main(String[] args) {
        Nqueens s = new Nqueens();
        System.out.println(s.nqueensII(8));

    }

}
