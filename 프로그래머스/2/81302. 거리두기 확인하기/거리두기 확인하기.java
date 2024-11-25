import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] ch;

    public static boolean BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        ch = new int[5][5];
        ch[x][y]=1;
        int cnt = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if (nx>=0 && ny >=0 && nx <5 && ny<5 && ch[nx][ny]==0) {
                        if (graph[nx][ny]=='P') return false;
                        else if (cnt == 0 && graph[nx][ny]=='O') {
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            cnt++;
        }
        return true;
    }

    public int[] solution(String[][] places) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (String[] x : places) {
            graph = new char[5][5];
            for (int i = 0; i < 5; i++) {
                String tmp = x[i];
                for (int j = 0; j < 5; j++) {
                    graph[i][j] = tmp.charAt(j);
                }
            }
            boolean flag = false;
            for (int i = 0; i < 5; i++) {
                if (flag) break;
                for (int j = 0; j < 5; j++) {
                    if (flag) break;
                    if (graph[i][j] == 'P') {
                        if (!BFS(i, j)) {
                            flag = true;
                        }
                    }
                }
            }
            if (flag) answer.add(0);
            else answer.add(1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}