import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static int r,c;
    static char[][] graph;
    static int[][] ch;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static Queue<Point> wq= new LinkedList<>();
    static Queue<Point> lq= new LinkedList<>();

    public static boolean lBFS() {
        Queue<Point> tmpq=new LinkedList<>();
        while (!lq.isEmpty()) {
            Point ltmp= lq.poll();
            for (int i=0; i<4; i++) {
                int nx=ltmp.x+dx[i];
                int ny=ltmp.y+dy[i];
                if (nx>=0 && nx<r && ny>=0 && ny<c && graph[nx][ny]=='.' && ch[nx][ny]==0) {
                    ch[nx][ny]=1;
                    lq.offer(new Point(nx,ny));
                }
                else if (nx>=0 && nx<r && ny>=0 && ny<c && graph[nx][ny]=='X' && ch[nx][ny]==0) {
                    ch[nx][ny]=1;
                    tmpq.offer(new Point(nx,ny));
                }
                else if (nx>=0 && nx<r && ny>=0 && ny<c && graph[nx][ny]=='L' && ch[nx][ny]==0) {
                    return true;
                }
            }
        }
        lq=tmpq;
        return false;
    }

    public static void wBFS() {
        int L=0;
        if (lBFS()) {
            System.out.print(L);
            return;
        }
        while (!wq.isEmpty()) {
            int len=wq.size();
            for (int i=0; i<len; i++) {
                Point wtmp= wq.poll();
                for (int j=0; j<4; j++) {
                    int nx = wtmp.x + dx[j];
                    int ny = wtmp.y + dy[j];
                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && graph[nx][ny] == 'X') {
                        graph[nx][ny] = '.';
                        wq.offer(new Point(nx,ny));
                    }
                }
            }
            L++;
            if (lBFS()) {
                System.out.print(L);
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        graph=new char[r][c];
        ch=new int[r][c];
        int cnt=0;
        for (int i=0; i<r; i++) {
            String str = br.readLine();
            for (int j=0; j<c; j++) {
                graph[i][j]=str.charAt(j);
                if (cnt==0 && graph[i][j]=='L') {
                    cnt++;
                    ch[i][j]=1;
                    lq.offer(new Point(i,j));
                }
                if (graph[i][j]=='L' || graph[i][j]=='.') wq.offer(new Point(i,j));
            }
        }
        wBFS();
    }
}
