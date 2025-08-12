import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        graph = new ArrayList<>(N + 1);
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] scores = new int[N + 1];
        int best = Integer.MAX_VALUE;

        for (int v = 1; v <= N; v++) {
            scores[v] = bfsScore(v);
            best = Math.min(best, scores[v]);
        }

        List<Integer> candidates = new ArrayList<>();
        for (int v = 1; v <= N; v++) if (scores[v] == best) candidates.add(v);

        StringBuilder out = new StringBuilder();
        out.append(best).append(' ').append(candidates.size()).append('\n');
        for (int i = 0; i < candidates.size(); i++) {
            if (i > 0) out.append(' ');
            out.append(candidates.get(i));
        }
        System.out.println(out.toString());
    }

    private static int bfsScore(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph.get(cur)) {
                if (dist[nxt] != -1) continue;
                dist[nxt] = dist[cur] + 1;
                q.add(nxt);
            }
        }

        int max = 0;
        for (int v = 1; v <= N; v++) {
            max = Math.max(max, dist[v]);
        } 
        return max;
    }
}