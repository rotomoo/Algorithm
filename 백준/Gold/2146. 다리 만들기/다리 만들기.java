import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Island {
        int x, y, dist, id;

        Island(int x, int y, int dist, int id) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int islandId = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    labelIsland(i, j, islandId++);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int id = 2; id < islandId; id++) {
            answer = Math.min(answer, bfs(id));
        }

        System.out.println(answer);
    }

    private static void labelIsland(int x, int y, int id) {
        Queue<Island> q = new LinkedList<>();
        q.offer(new Island(x, y, 0, id));
        visited[x][y] = true;
        map[x][y] = id;

        while (!q.isEmpty()) {
            Island cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = id;
                    q.offer(new Island(nx, ny, 0, id));
                }
            }
        }
    }

    private static int bfs(int id) {
        Queue<Island> q = new LinkedList<>();
        boolean[][] visitedBfs = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == id) {
                    q.offer(new Island(i, j, 0, id));
                    visitedBfs[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Island cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (!inRange(nx, ny) || visitedBfs[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    visitedBfs[nx][ny] = true;
                    q.offer(new Island(nx, ny, cur.dist + 1, id));
                } else if (map[nx][ny] != id) {
                    return cur.dist;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}