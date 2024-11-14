import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int m,n;
    static int answer=0;

    public static void DFS(int x, int y) {
        for (int i=0; i<=3; i++) {
            int nx= x+dx[i];
            int ny= y+dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && graph[nx][ny] == 1) {
                graph[nx][ny]=0;
                DFS(nx,ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph=new int[m][n];
            for (int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken());
                int y= Integer.parseInt(st.nextToken());
                graph[x][y]=1;
            }
            for (int j=0; j<m; j++) {
                for (int l=0; l<n; l++) {
                    if (graph[j][l]==1) {
                        answer++;
                        graph[j][l]=0;
                        DFS(j,l);
                    }
                }
            }
            bw.write(answer+"\n");
            answer=0;
        }
        bw.flush();
        bw.close();
    }
}
