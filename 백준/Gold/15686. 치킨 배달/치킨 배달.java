import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,m, answer=Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> hs, ck;

    public static void dfs(int L, int s) {
        if (L==m) {
            calcDis();
        }
        else {
            for (int i=s; i<ck.size(); i++) {
                combi[L]=i;
                dfs(L+1, i+1);
            }
        }
    }

    public static void calcDis() {
        int sum = 0;
        for (Point h : hs) {
            int dis = Integer.MAX_VALUE;
            for (int i : combi) {
                dis = Math.min(dis, Math.abs(ck.get(i).x - h.x) + Math.abs(ck.get(i).y - h.y));
            }
            sum += dis;
        }
        answer = Math.min(answer,sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        hs = new ArrayList<>();
        ck = new ArrayList<>();
        combi = new int[m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp==1) {
                    hs.add(new Point(i,j));
                }
                else if (tmp==2) {
                    ck.add(new Point(i,j));
                }
            }
        }
        dfs(0,0);
        System.out.println(answer);
    }
}