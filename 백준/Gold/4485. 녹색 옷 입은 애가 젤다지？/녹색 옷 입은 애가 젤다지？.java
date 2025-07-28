import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x, y, cost;
        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    private static int findMoney() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = map[0][0];
        pq.add(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;

            if (cost > dist[x][y]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int newCost = cost + map[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.add(new Node(nx, ny, newCost));
                    }
                }
            }
        }

        return dist[N - 1][N - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNum = 1;

        while (true) {
            N = sc.nextInt();
            if (N == 0) break;

            map = new int[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    map[i][j] = sc.nextInt();

            int result = findMoney();
            System.out.println("Problem " + testNum++ + ": " + result);
        }

        sc.close();
    }
}