import java.util.*;

public class Main {
    static class Coordinate implements Comparable<Coordinate> {
        int x, y, dir, mirrors;

        Coordinate(int x, int y, int dir, int mirrors) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirrors = mirrors;
        }

        @Override
        public int compareTo(Coordinate o) {
            return Integer.compare(this.mirrors, o.mirrors);
        }
    }

    static int W, H;
    static char[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 상 우 하 좌
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        H = sc.nextInt();
        map = new char[H][W];
        visited = new int[H][W][4];

        List<int[]> cList = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            String line = sc.next();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') cList.add(new int[]{i, j});
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        int[] start = cList.get(0);
        int[] end = cList.get(1);

        PriorityQueue<Coordinate> pq = new PriorityQueue<>();
        for (int d = 0; d < 4; d++) {
            visited[start[0]][start[1]][d] = 0;
            pq.offer(new Coordinate(start[0], start[1], d, 0));
        }

        while (!pq.isEmpty()) {
            Coordinate now = pq.poll();

            if (now.x == end[0] && now.y == end[1]) {
                System.out.println(now.mirrors);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (map[nx][ny] == '*') continue;

                int nextMirrors = now.mirrors + (now.dir == d ? 0 : 1);
                if (visited[nx][ny][d] > nextMirrors) {
                    visited[nx][ny][d] = nextMirrors;
                    pq.offer(new Coordinate(nx, ny, d, nextMirrors));
                }
            }
        }
    }
}