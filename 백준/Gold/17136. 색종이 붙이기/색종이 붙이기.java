import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[10][10];
    static int[] paperCount = {0, 5, 5, 5, 5, 5};
    static int minPaperUsed = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0, 0);

        if (minPaperUsed == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minPaperUsed);
        }
    }

    private static void backtrack(int r, int c, int count) {
        if (count >= minPaperUsed) {
            return;
        }

        if (c >= 10) {
            backtrack(r + 1, 0, count);
            return;
        }

        if (r >= 10) {
            minPaperUsed = Math.min(minPaperUsed, count);
            return;
        }

        if (map[r][c] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (paperCount[size] > 0 && canPlace(r, c, size)) {
                    placeOrRemove(r, c, size, 0);
                    paperCount[size]--;

                    backtrack(r, c + size, count + 1);

                    placeOrRemove(r, c, size, 1);
                    paperCount[size]++;
                }
            }
        } else {
            backtrack(r, c + 1, count);
        }
    }

    private static boolean canPlace(int r, int c, int size) {
        if (r + size > 10 || c + size > 10) {
            return false;
        }

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void placeOrRemove(int r, int c, int size, int value) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = value;
            }
        }
    }
}