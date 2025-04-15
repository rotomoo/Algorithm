import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int vex, usa;
        Point(int vex, int usa) {
            this.vex = vex;
            this.usa = usa;
        }
    }

    static ArrayList<ArrayList<Point>> graph;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Point(b, w));
            graph.get(b).add(new Point(a, w));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bw.write(calcCnt(k,v)+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int calcCnt(int k, int v) {
        int cnt = 0;
        int[] ch = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        ch[v] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Point next : graph.get(cur)) {
                if (ch[next.vex]==1)
                    continue;
                if (k > next.usa)
                    continue;
                ch[next.vex] = 1;
                cnt++;
                q.add(next.vex);
            }
        }
        return cnt;
    }
}