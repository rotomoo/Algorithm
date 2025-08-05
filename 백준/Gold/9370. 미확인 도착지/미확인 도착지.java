import java.util.*;
import java.io.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static final int INF = 1_000_000_000;
    static List<List<Edge>> graph;

    static int[] findShortestPath(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (dist[cur.to] < cur.cost) continue;

            for (Edge next : graph.get(cur.to)) {
                int newDist = cur.cost + next.cost;
                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.offer(new Edge(next.to, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

            int ghCost = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.get(a).add(new Edge(b, d));
                graph.get(b).add(new Edge(a, d));

                if ((a == g && b == h) || (a == h && b == g)) ghCost = d;
            }

            List<Integer> targets = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                targets.add(Integer.parseInt(br.readLine()));
            }

            int[] fromS = findShortestPath(s, n);
            int[] fromG = findShortestPath(g, n);
            int[] fromH = findShortestPath(h, n);

            List<Integer> answer = new ArrayList<>();
            for (int x : targets) {
                int path1 = fromS[g] + ghCost + fromH[x];
                int path2 = fromS[h] + ghCost + fromG[x];
                if (fromS[x] == path1 || fromS[x] == path2) answer.add(x);
            }

            Collections.sort(answer);
            for (int x : answer) result.append(x).append(" ");
            result.append("\n");
        }

        System.out.print(result);
    }
}