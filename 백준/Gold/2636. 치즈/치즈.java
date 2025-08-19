import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        int initialCheeseCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    initialCheeseCount++;
                }
            }
        }

        int time = 0;
        int lastCheeseCount = 0;

        while (initialCheeseCount > 0) {
            time++;
            lastCheeseCount = initialCheeseCount;

            findOutsideAir();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1 && isMeltingTarget(i, j)) {
                        board[i][j] = -1;
                    }
                }
            }

            int currentCheeseCount = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == -1) {
                        board[i][j] = 0;
                    } else if (board[i][j] == 1) {
                        currentCheeseCount++;
                    }
                }
            }
            initialCheeseCount = currentCheeseCount;
        }

        System.out.println(time);
        System.out.println(lastCheeseCount);
    }

    public static void findOutsideAir() {
        visited = new boolean[N][M];
        Queue<Coordinate> queue = new LinkedList<>();
        
        queue.offer(new Coordinate(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && board[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        queue.offer(new Coordinate(nx, ny));
                    }
                }
            }
        }
    }

    public static boolean isMeltingTarget(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (visited[nx][ny]) {
                    return true;
                }
            }
        }
        return false;
    }
}