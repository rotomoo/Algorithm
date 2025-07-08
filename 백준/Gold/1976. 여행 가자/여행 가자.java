import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    graph[i].add(j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] trip = new int[m];
        for (int i = 0; i < m; i++) {
            trip[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n + 1];
        bfs(trip[0]);

        String answer = "YES";
        for (int city : trip) {
            if (!visited[city]) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
}