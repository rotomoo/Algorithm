import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point {
        int x, y, direction;

        public Point(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
    static ArrayList<Integer> answer;
    static int width, height;
    static int[][][] ch;
    static Point first;
    static char[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int isCheck(int tmp, int max) {
        if (tmp==-1) tmp = max - 1;
        else if (tmp == max) tmp = 0;
        return tmp;
    }

    public static void BFS(int x, int y, int direction) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, direction));
        int cnt = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point tmp = q.poll();
                ch[tmp.x][tmp.y][tmp.direction]=1;
                int nx = tmp.x + dx[tmp.direction];
                int ny = tmp.y + dy[tmp.direction];
                nx = isCheck(nx, height);
                ny = isCheck(ny, width);
                if (graph[nx][ny]=='L') tmp.direction--;
                else if (graph[nx][ny]=='R') tmp.direction++;
                tmp.direction = isCheck(tmp.direction, 4);
                if (ch[nx][ny][tmp.direction] == 1) {
                    if (first.x==nx && first.y==ny && first.direction == tmp.direction) {
                        answer.add(cnt);
                        return;
                    }
                    else return;
                }
                q.offer(new Point(nx, ny, tmp.direction));
            }
            cnt++;
        }
    }

    public static int[] solution(String[] grid) {
        answer = new ArrayList();
        width = grid[0].length();
        height = grid.length;
        graph = new char[height][width];
        ch = new int[height][width][4];
        for (int i = 0; i < height; i++) {
            String tmp = grid[i];
            for (int j = 0; j < width; j++) {
                graph[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (int k = 0; k < 4; k++) {
                    first = new Point(i, j, k);
                    BFS(i,j,k);
                }
            }
        }
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}