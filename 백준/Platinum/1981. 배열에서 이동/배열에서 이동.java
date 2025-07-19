import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Coordinate {
        int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        int minVal = 201;
        int maxVal = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                minVal = Math.min(minVal, map[i][j]);
                maxVal = Math.max(maxVal, map[i][j]);
            }
        }

        int left = 0;
        int right = maxVal - minVal;
        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean reachYn = false;

            for (int low = minVal; low + mid <= maxVal; low++) {
                int high = low + mid;
                visited = new boolean[n][n];

                if (map[0][0] < low || map[0][0] > high) continue;

                if (bfs(low, high)) {
                    reachYn = true;
                    break;
                }
            }

            if (reachYn) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean bfs(int low, int high) {
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Coordinate now = q.poll();
            if (now.x == n - 1 && now.y == n - 1) return true;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] < low || map[nx][ny] > high) continue;

                visited[nx][ny] = true;
                q.add(new Coordinate(nx, ny));
            }
        }

        return false;
    }
}