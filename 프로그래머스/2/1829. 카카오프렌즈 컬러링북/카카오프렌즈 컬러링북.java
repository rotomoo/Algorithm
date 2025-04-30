import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point {
        int x,y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    static Queue<Point> q = new LinkedList<>();
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static int maxSizeOfOneArea=0;

    public void bfs(int m,int n,int[][] map,int value) {
        int cnt=1;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i=0; i<4; i++) {
                int nx=tmp.x+dx[i];
                int ny=tmp.y+dy[i];
                if (nx>=0 && ny>=0 && nx<m && ny<n) {
                    if (map[nx][ny]==value) {
                        cnt++;
                        map[nx][ny]=0;
                        q.offer(new Point(nx,ny));
                    }
                }
            }
        }
        maxSizeOfOneArea=Math.max(maxSizeOfOneArea,cnt);
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        maxSizeOfOneArea=0;
        int[][]map=new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                map[i][j]=picture[i][j];
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (map[i][j]!=0) {
                    numberOfArea++;
                    int value=map[i][j];
                    map[i][j]=0;
                    q.offer(new Point(i,j));
                    bfs(m,n,map,value);
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        for (int x : answer) System.out.println(x);
        return answer;
    }
}
