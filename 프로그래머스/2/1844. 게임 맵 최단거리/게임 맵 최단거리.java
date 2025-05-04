import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[][] ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] Map;
    static class Point {
        int x , y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        ch[x][y]=1;
        q.offer(new Point(x, y));
        int cnt = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx == Map.length-1 && ny == Map[0].length-1) return cnt + 1;
                    if (isIn(nx, ny) && ch[nx][ny]==0) {
                        ch[nx][ny]=1;
                        if (Map[nx][ny]==1) {
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public static boolean isIn(int nx, int ny) {
        if (nx>=0 && nx < Map.length && ny >= 0 && ny < Map[0].length) return true;
        return false;
    }

    public int solution(int[][] maps) {
        ch = new int[maps.length][maps[0].length];
        Map = maps;
        return bfs(0,0);
    }
}