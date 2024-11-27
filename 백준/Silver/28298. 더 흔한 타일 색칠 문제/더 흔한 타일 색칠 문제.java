import java.io.*;
import java.util.*;


public class Main {

    static int N, M, K, ans1;
    static char[][] d, ans2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        d = new char[N][];
        for (int i = 0; i < N; i++) {
            d[i] = br.readLine().toCharArray();
        }

        ans2 = new char[K][K];
        int repeatR = N / K;
        int repeatC = M / K;
        int repeat = repeatR * repeatC;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int[] cnt = new int[26];
                for (int r = i; r < N; r += K) {
                    for (int c = j; c < M; c += K) {
                        cnt[d[r][c] - 'A']++;
                    }
                }
                int maxCnt = cnt[0];
                char bestChar = 'A';
                for (int t = 1; t < cnt.length; t++) {
                    if (cnt[t] > maxCnt) {
                        maxCnt = cnt[t];
                        bestChar = (char) ('A' + t);
                    }
                }
                ans1 += repeat - maxCnt;
                ans2[i][j] = bestChar;
            }
        }

        StringBuilder sb1 = new StringBuilder();
        for (int r = 0; r < K; r++) {
            for (int c = 0; c < repeatC; c++) {
                sb1.append(ans2[r]);
            }
            sb1.append('\n');
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < repeatR; i++) {
            sb2.append(sb1);
        }
        System.out.println(ans1);
        System.out.print(sb2);
    }
}