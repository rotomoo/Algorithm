import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static char[][] graph;
    static int h,w;
    static Deque<Point> q1 = new ArrayDeque<>();
    static Deque<Point> q2 = new ArrayDeque<>();
    static Deque<Point> q3 = new ArrayDeque<>();
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};


    public static int[][] BFS(Deque<Point> q) {
        int[][] dis = new int[h+2][w+2];
        int[][] ch = new int[h+2][w+2];
        while (!q.isEmpty()) {
            Point tmp =q.poll();
            ch[tmp.x][tmp.y]=1;
            for (int i=0; i<4; i++) {
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if (nx>=0 && ny>=0 && nx<=h+1 && ny<=w+1) {
                    if (ch[nx][ny]==0) {
                        ch[nx][ny]=1;
                        if (graph[nx][ny]=='*') continue;
                        else if (graph[nx][ny]=='#') {
                            dis[nx][ny]=dis[tmp.x][tmp.y]+1;
                            q.offerLast(new Point(nx,ny));
                        }
                        else {
                            dis[nx][ny]=dis[tmp.x][tmp.y];
                            q.offerFirst(new Point(nx,ny));
                        }
                    }
                }
            }
        }
        for (int i=0; i<=h+1; i++) {
            for (int j=0; j<=w+1; j++) {
                if (ch[i][j]==0 && dis[i][j]==0) dis[i][j]=10000;
            }
        }
        return dis;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int n=0; n<t; n++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            h=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());
            graph=new char[h+2][w+2];
            int cnt=0;
            for (int i=1; i<=h; i++) {
                String str = br.readLine();
                for (int j=1; j<=w; j++) {
                    graph[i][j]=str.charAt(j-1);
                    if (cnt==0 && graph[i][j]=='$') {
                        cnt++;
                        q2.offer(new Point(i,j));
                    }
                    else if (cnt==1 && graph[i][j]=='$') q3.offer(new Point(i,j));
                }
            }
            q1.offer(new Point(0,0));
            int[][] s= BFS(q1);
            int[][] p1= BFS(q2);
            int[][] p2= BFS(q3);
            int[][] tmp = new int[h+2][w+2];
            int answer=Integer.MAX_VALUE;
            for (int i=0; i<=h+1; i++) {
                for (int j=0; j<=w+1; j++) {
                    if (graph[i][j]=='*') continue;
                    tmp[i][j]=s[i][j]+p1[i][j]+p2[i][j];
                    if (graph[i][j]=='#') {
                        tmp[i][j]-=2;
                    }
                    answer=Math.min(answer,tmp[i][j]);
                }
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
