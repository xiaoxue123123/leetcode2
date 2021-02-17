package DP;

public class LongestCrossOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] left = new int[M+2][N+2];
        int[][] right = new int[M+2][N+2];
        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    left[i+1][j+1] = left[i+1][j] + 1;
                    right[i+1][j+1] = right[i][j] + 1;
                    int maxLength = Math.min(left[i+1][j+1],right[i+1][j+1]);
                    for (int k = maxLength; k> 0; k--) {
                        // check left arm of right point, and right arm of left point
                        if (left[i-k+1][j-k+1] >= k && right[i+k][j-k+2] >= k && k > result) {
                            result = k;
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        LongestCrossOf1s s = new LongestCrossOf1s();
        int[][] m = new int[][]{{0,1,1,0,1},{1,1,1,1,0},{0,0,1,0,1}};
        System.out.println(s.largest(m));
    }
}
