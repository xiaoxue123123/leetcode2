package DFS;

public class MinBox {

    public int minBox(int n) {
        if (n == 0) {
            return 0;
        }
        int[] numBox = new int[1];
        helper(numBox, n);
        return numBox[0];
    }

    private void helper(int[] numBox, int n) {
        if (n == 0) {
            return;
        }
        numBox[0]++;
        int sqrt = (int) Math.sqrt(n);
        helper(numBox, n - sqrt * sqrt);
    }

    public static void main(String[] args) {
        MinBox s = new MinBox();
        System.out.println(s.minBox(50));
    }

}



