import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Position {
        int x, y, count;
        Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static class State {
        int rx, ry, bx, by, depth;
        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
            }
        }

        int result = bfs(rx, ry, bx, by);
        System.out.println(result);
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new LinkedList<>();
        q.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.depth >= 10) return -1;

            for (int dir = 0; dir < 4; dir++) {
                Position nextRed = move(cur.rx, cur.ry, dx[dir], dy[dir]);
                Position nextBlue = move(cur.bx, cur.by, dx[dir], dy[dir]);

                if (board[nextBlue.x][nextBlue.y] == 'O') continue;
                if (board[nextRed.x][nextRed.y] == 'O') return cur.depth + 1;

                if (nextRed.x == nextBlue.x && nextRed.y == nextBlue.y) {
                    if (nextRed.count > nextBlue.count) {
                        nextRed.x -= dx[dir];
                        nextRed.y -= dy[dir];
                    } else {
                        nextBlue.x -= dx[dir];
                        nextBlue.y -= dy[dir];
                    }
                }

                if (!visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]) {
                    visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y] = true;
                    q.add(new State(nextRed.x, nextRed.y, nextBlue.x, nextBlue.y, cur.depth + 1));
                }
            }
        }

        return -1;
    }

    private static Position move(int x, int y, int dx, int dy) {
        int count = 0;
        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
            count++;
            if (board[x][y] == 'O') break;
        }
        return new Position(x, y, count);
    }
}