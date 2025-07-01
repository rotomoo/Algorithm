import java.util.*;

public class Main {
    static class Fish implements Comparable<Fish> {
        int x, y, dist;

        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.dist != o.dist) return Integer.compare(this.dist, o.dist);
            if (this.x != o.x) return Integer.compare(this.x, o.x);
            return Integer.compare(this.y, o.y);
        }
    }
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static int sharkX, sharkY, sharkSize = 2, eatCount = 0, time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }

        while (true) {
            Fish target = findFish();
            if (target == null) break;

            time += target.dist;
            sharkX = target.x;
            sharkY = target.y;
            map[sharkX][sharkY] = 0;

            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    private static Fish findFish() {
        visited = new boolean[N][N];
        Queue<Fish> queue = new LinkedList<>();
        PriorityQueue<Fish> candidates = new PriorityQueue<>();
        queue.offer(new Fish(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;

        while (!queue.isEmpty()) {
            Fish cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;

                if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {
                    candidates.offer(new Fish(nx, ny, cur.dist + 1));
                }

                queue.offer(new Fish(nx, ny, cur.dist + 1));
            }
        }

        if (candidates.isEmpty()) return null;
        return candidates.poll();
    }
}