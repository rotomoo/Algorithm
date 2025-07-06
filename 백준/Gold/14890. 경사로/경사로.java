import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        // 행 체크
        for (int i = 0; i < N; i++) {
            if (checkPath(map[i])) result++;
        }

        // 열 체크
        for (int i = 0; i < N; i++) {
            int[] col = new int[N];
            for (int j = 0; j < N; j++)
                col[j] = map[j][i];
            if (checkPath(col)) result++;
        }

        System.out.println(result);
    }

    private static boolean checkPath(int[] line) {
        boolean[] used = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            if (line[i] == line[i + 1]) continue;

            int diff = line[i] - line[i + 1];

            if (Math.abs(diff) > 1) return false;

            if (diff == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || line[j] != line[i + 1] || used[j]) return false;
                    used[j] = true;
                }
            } else if (diff == -1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || line[j] != line[i] || used[j]) return false;
                    used[j] = true;
                }
            }
        }

        return true;
    }
}