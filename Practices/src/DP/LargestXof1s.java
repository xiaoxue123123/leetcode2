package DP;

public class LargestXof1s {
    public int largest(int[][] matrix) {
        // Write your solution here
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] leftUp = new int[n+2][m+2];
        int[][] rightUp = new int[n+2][m+2];
        int[][] leftBottom = new int[n+2][m+2];
        int[][] rightBottom = new int[n+2][m+2];

        // for loop 1: fill the four matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i-1][j-1] == 1) {
                    leftUp[i][j] = leftUp[i-1][j-1] + 1;
                    rightUp[i][j] = rightUp[i-1][j+1] + 1;
                    rightBottom[i][j] = rightBottom[i + 1][j + 1] + 1;
                    leftBottom[i][j] = leftBottom[i + 1][j - 1] + 1;
                }
            }
        }
        int max = 0;
        // for loop 2: find max X
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int cur = Math.min(Math.min(Math.min(leftUp[i][j],leftBottom[i][j]),rightUp[i][j]),rightBottom[i][j]);
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestXof1s s = new LargestXof1s();
        int[][] m = new int[][]{{0,0,0,0},{1,1,1,1},{0,1,1,1},{1,0,1,1}};
        int n = s.largest(m);
    }
}
