import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point5 {
    public int x,y;

    Point5 (int x, int y) {
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] graph,dis;
    static Queue<Point5> q = new LinkedList<>();

    public static void bfs() {
        while (!q.isEmpty()) {
            Point5 tmp = q.poll();
            for (int i=0; i<4; i++) {
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if (nx>=0 && nx<m && ny>=0 && ny<n &&graph[nx][ny]==0) {
                    graph[nx][ny]=1;
                    q.offer(new Point5(nx,ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        dis = new int[m][n];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                graph[i][j]=Integer.parseInt(st.nextToken());
                if (graph[i][j]==1) q.offer(new Point5(i,j));
            }
        }
        bfs();
        int answer=0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (graph[i][j]==0) {
                    System.out.print(-1);
                    return;
                }
                else answer=Math.max(answer,dis[i][j]);
            }
        }
        System.out.print(answer);
    }
}
