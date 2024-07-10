import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point4 {
    int x, y;
    Point4(int x, int y) {
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static int n,m;
    static int[][] graph, dis;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};

    public static void BFS(int x, int y) {
        Queue<Point4> q = new LinkedList<>();
        q.offer(new Point4(x,y));
        while (!q.isEmpty()) {
            Point4 tmp = q.poll();
            for (int i=0; i<=3; i++) {
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if (nx>=1 && nx<=n && ny>=1 && ny<=m && graph[nx][ny]==1) {
                    graph[nx][ny]=0;
                    q.offer(new Point4(nx,ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        graph= new int[n+1][m+1];
        dis= new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            String tmp = br.readLine();
            for (int j=1; j<=m; j++) {
                graph[i][j]=Integer.parseInt(String.valueOf(tmp.charAt(j-1)));
            }
        }
        graph[1][1]=0;
        dis[1][1]=1;
        BFS(1,1);
        System.out.print(dis[n][m]);
    }
}