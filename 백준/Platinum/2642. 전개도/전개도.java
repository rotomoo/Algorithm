import java.util.*;

public class Main {
    static int[][] a = new int[8][8];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] pairs = new int[7];

    static class State {
        int x, y, dir, cnt;

        State(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (a[i][j] != 0) {
                    boolean[] path = new boolean[7];
                    path[a[i][j]] = true;
                    bfs(i, j, -1, 0, a[i][j], path);
                }
            }
        }

        for (int i = 1; i <= 6; i++) {
            if (pairs[i] == 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(pairs[1]);
    }

    private static void bfs(int x, int y, int dir, int cnt, int n, boolean[] path) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(x, y, dir, cnt));

        while (!q.isEmpty()) {
            State cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx <= 0 || ny <= 0 || nx >= 7 || ny >= 7) continue;
                int target = a[nx][ny];
                if (target == 0 || path[target]) continue;

                path[target] = true;

                if (cur.dir == -1) {
                    q.offer(new State(nx, ny, d, 1));
                } else if (cur.dir == d && cur.cnt == 1 &&
                        (pairs[n] == 0 || pairs[n] == target) &&
                        (pairs[target] == 0 || pairs[target] == n)) {
                    pairs[n] = target;
                    pairs[target] = n;
                    q.offer(new State(nx, ny, d, cur.cnt + 1));
                } else {
                    q.offer(new State(nx, ny, cur.dir, cur.cnt));
                }
            }
        }
    }
}