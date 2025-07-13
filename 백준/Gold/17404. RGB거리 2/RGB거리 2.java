import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        int answer = INF;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N][3];

            for (int i = 0; i < 3; i++) {
                if (i == firstColor)
                    dp[0][i] = cost[0][i];
                else
                    dp[0][i] = INF;
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0]; // R
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1]; // G
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2]; // B
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == firstColor) continue;
                answer = Math.min(answer, dp[N - 1][lastColor]);
            }
        }

        System.out.println(answer);
    }
}