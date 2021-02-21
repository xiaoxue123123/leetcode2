package DP;

public class MinimumDifficultyofaJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {

        int n = jobDifficulty.length;
        int[][] dp = new int[d + 1][n + 1];
        for (int i = 0; i < d + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
                if (j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        dp[0][0] = 0;

        int[] max = new int[n + 1];
        int m = Integer.MIN_VALUE;
        for (int i = n; i >= 1; i--) {
            //System.out.println(i);
            m = Math.max(m, jobDifficulty[i - 1]);
            max[i] = m;
            dp[1][i] = m;
        }
        max[0] = 0;

        for (int i = 1; i < d + 1; i++) { // num of days
            for (int j = 1; j < n + 1; j++) { // num of jobs
                if (i > j) {
                    continue;
                }
                int curMin = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    //  System.out.println( " i - 1:" + (i - 1) + " k - 1 " +(k - 1) + " j " + j);
                    // System.out.println(dp[i - 1][k - 1]);
                    //  System.out.println("max[k] " + max[k]);
                    curMin = Math.min(curMin, dp[i - 1][k - 1] + max[k]);
                }
                dp[i][j] = curMin;

            }

        }
        return d > jobDifficulty.length ? -1 : dp[d][n];


    }
    public static void main(String[] args) {
        MinimumDifficultyofaJobSchedule s = new MinimumDifficultyofaJobSchedule();
        System.out.println(s.minDifficulty(new int[]{6,12},2));
    }
}

