package Array;

public class Game {
    public boolean divisorGame(int N) {
        if (N <= 1) {
            return false;
        }

        boolean[] dp = new boolean[N+1];
        dp[0] = false;
        dp[1] = false;
        for (int x = 2; x <= N; x++) {
            for (int i = x - 1;  i >= 1; i--) {
                if (x % i == 0 && !dp[x - i]) {
                    dp[x] = true;
                    break;
                }
            }
        }
        return dp[N];

    }
    public static void main(String[] args) {
//        Game s = new Game();
//        System.out.println(s.divisorGame(4));

        for (int i = 1; i <= 6 && 10 % i == 0; i++) {
            System.out.println(i);
        }
    }
}
