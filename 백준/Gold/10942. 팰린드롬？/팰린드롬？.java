import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1]; // 1-indexed
        dp = new boolean[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 길이 1
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        // 길이 2
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        // 길이 3 이상
        for (int len = 3; len <= N; len++) {
            for (int s = 1; s <= N - len + 1; s++) {
                int e = s + len - 1;
                if (arr[s] == arr[e] && dp[s + 1][e - 1]) {
                    dp[s][e] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] ? "1\n" : "0\n");
        }

        System.out.print(sb);
    }
}