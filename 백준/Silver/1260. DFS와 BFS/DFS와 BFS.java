import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] ch;

    public static void DFS(int sv) {
        System.out.print(sv+" ");
        for (int ev = 1; ev <= n; ev++) {
            if (ch[ev] == 0 && map[sv][ev] == 1) {
                ch[ev] = 1;
                DFS(ev);
            }
        }
    }

    public static void BFS(int sv) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(sv);
        while (!q.isEmpty()) {
            int poll = q.poll();
            System.out.print(poll+" ");
            for (int ev = 1; ev <= n; ev++) {
                if (ch[ev] == 0 && map[poll][ev] == 1) {
                    ch[ev] = 1;
                    q.offer(ev);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        ch = new int[n+1];
        ch[v] = 1;
        DFS(v);
        System.out.println();
        ch = new int[n+1];
        ch[v] = 1;
        BFS(v);
    }
}
