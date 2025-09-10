import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] dp = new int[61][61][61];
    static int[][] attacks = {
            {9, 3, 1}, {9, 1, 3}, {3, 9, 1},
            {3, 1, 9}, {1, 9, 3}, {1, 3, 9}
    };

    static class ScvState {
        int h1, h2, h3;

        public ScvState(int h1, int h2, int h3) {
            this.h1 = h1;
            this.h2 = h2;
            this.h3 = h3;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] initialScvHealth = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            initialScvHealth[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= 60; i++) {
            for (int j = 0; j <= 60; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(bfs(new ScvState(initialScvHealth[0], initialScvHealth[1], initialScvHealth[2])));
    }

    private static int bfs(ScvState startState) {
        Queue<ScvState> queue = new LinkedList<>();

        queue.add(startState);
        dp[startState.h1][startState.h2][startState.h3] = 0;

        while (!queue.isEmpty()) {
            ScvState current = queue.poll();

            if (current.h1 == 0 && current.h2 == 0 && current.h3 == 0) {
                return dp[current.h1][current.h2][current.h3];
            }

            for (int i = 0; i < 6; i++) {
                int nh1 = Math.max(0, current.h1 - attacks[i][0]);
                int nh2 = Math.max(0, current.h2 - attacks[i][1]);
                int nh3 = Math.max(0, current.h3 - attacks[i][2]);

                if (dp[nh1][nh2][nh3] == -1) {
                    dp[nh1][nh2][nh3] = dp[current.h1][current.h2][current.h3] + 1;
                    queue.add(new ScvState(nh1, nh2, nh3));
                }
            }
        }
        
        return 0;
    }
}