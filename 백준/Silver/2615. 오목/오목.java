import java.io.*;
import java.util.*;

public class Main {
    static final int N = 19;

    static final int[] dx = {-1, 0, 1, 1};
    static final int[] dy = { 1, 1, 1, 0};

    private static boolean inBounds(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[N][N];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                int color = board[r][c];
                if (color == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int pr = r - dx[d], pc = c - dy[d];
                    if (inBounds(pr, pc) && board[pr][pc] == color) continue;

                    int cnt = 1;
                    int nr = r + dx[d], nc = c + dy[d];
                    while (inBounds(nr, nc) && board[nr][nc] == color) {
                        cnt++;
                        nr += dx[d];
                        nc += dy[d];
                    }

                    if (cnt == 5) {
                        System.out.println(color);
                        System.out.println((r + 1) + " " + (c + 1));
                        return;
                    }
                }
            }
        }

        System.out.println(0);
    }
}