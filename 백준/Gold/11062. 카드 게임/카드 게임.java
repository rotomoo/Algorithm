import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] cards = new int[N];
            
            int[] prefixSum = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
                prefixSum[i + 1] = prefixSum[i] + cards[i];
            }

            int[][] dp = new int[N][N];

            for (int len = 1; len <= N; len++) {
                for (int i = 0; i <= N - len; i++) {
                    int j = i + len - 1;

                    if (i == j) {
                        dp[i][i] = cards[i];
                        continue;
                    }

                    int sumLeftSub = prefixSum[j + 1] - prefixSum[i + 1];
                    int scoreIfTakeLeft = cards[i] + (sumLeftSub - dp[i + 1][j]);

                    int sumRightSub = prefixSum[j] - prefixSum[i];
                    int scoreIfTakeRight = cards[j] + (sumRightSub - dp[i][j - 1]);
                    
                    dp[i][j] = Math.max(scoreIfTakeLeft, scoreIfTakeRight);
                }
            }
            
            sb.append(dp[0][N - 1]).append('\n');
        }
        System.out.print(sb);
    }
}