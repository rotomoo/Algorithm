import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[][] grid;
    static int[][] height;
    static int startX;
    static int startY;
    static int totalK;

    static final int[] dx = {-1,-1,-1,0,0,1,1,1};
    static final int[] dy = {-1,0,1,-1,1,-1,0,1};

    static class Coordinate {
        int x;
        int y;
        
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'P') { startX = i; startY = j; }
                if (grid[i][j] == 'K') totalK++;
            }
        }

        height = new int[N][N];
        ArrayList<Integer> allHeights = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                allHeights.add(height[i][j]);
            }
        }

        Collections.sort(allHeights);
        ArrayList<Integer> vals = new ArrayList<>();
        int prev = -1;
        
        for (int h : allHeights) {
            if (h != prev) {
                vals.add(h);
            }
            prev = h;
        }

        int ans = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int startH = height[startX][startY];

        while (left < vals.size() && right < vals.size()) {
            int low = vals.get(left);
            int high = vals.get(right);

            if (startH < low || startH > high) {
                if (startH < low) {
                    left++;
                } else {
                    right++;
                }
                continue;
            }

            if (canReachAll(low, high)) {
                ans = Math.min(ans, high - low);
                left++;
            } else {
                right++;
            }
        }

        System.out.println(ans);
    }

    private static boolean canReachAll(int low, int high) {
        if (height[startX][startY] < low || height[startX][startY] > high) return false;

        boolean[][] visited = new boolean[N][N];
        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(startX, startY));
        visited[startX][startY] = true;

        int reachedK = 0;

        while (!q.isEmpty()) {
            Coordinate cur = q.poll();
            int x = cur.x, y = cur.y;

            if (grid[x][y] == 'K') reachedK++;

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;
                int nh = height[nx][ny];
                if (nh < low || nh > high) continue;
                visited[nx][ny] = true;
                q.add(new Coordinate(nx, ny));
            }
        }
        return reachedK == totalK;
    }
}