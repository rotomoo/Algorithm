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
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] graph;
    static ArrayList<Integer> answer;

    public static int[][] BFS(int sx, int sy, int ex, int ey) {
        int curDirection = 0;
        int curVal = Integer.MAX_VALUE;
        int[][] ch = new int[graph.length][graph[0].length];
        Queue<Point> q = new LinkedList<>();
        int[][] newGraph = new int[graph.length][graph[0].length];
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[0].length; j++) {
                newGraph[i][j] = graph[i][j];
            }
        }
        q.offer(new Point(sx, sy));
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            curVal = Math.min(curVal, graph[tmp.x][tmp.y]);
            if (tmp.x==sx && tmp.y ==ey) curDirection++;
            else if (tmp.x==ex && tmp.y ==ey) curDirection++;
            else if (tmp.x==ex && tmp.y ==sy) curDirection++;
            else if (tmp.x==sx && tmp.y ==sy) curDirection = 0;
            int nx = tmp.x + dx[curDirection];
            int ny = tmp.y + dy[curDirection];
            if (ch[nx][ny]==1) break;
            ch[nx][ny]=1;
            newGraph[nx][ny] = graph[tmp.x][tmp.y];
            q.offer(new Point(nx, ny));
        }
        answer.add(curVal);
        return newGraph;
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        answer = new ArrayList<>();
        graph = new int[rows+1][columns+1];
        int val = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                graph[i][j] = val++;
            }
        }

        for (int[] x : queries) {
            graph = BFS(x[0], x[1], x[2], x[3]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}