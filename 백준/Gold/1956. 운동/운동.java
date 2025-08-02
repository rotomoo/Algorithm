import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        int answer = INF;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, findCycle(i));
        }

        System.out.println(answer == INF ? -1 : answer);
    }

    static int findCycle(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > dist[cur.to]) continue;

            for (Edge next : graph.get(cur.to)) {
                if (dist[next.to] > cur.cost + next.cost) {
                    dist[next.to] = cur.cost + next.cost;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }

        int minCycle = INF;
        for (int i = 1; i <= V; i++) {
            if (i == start) continue;
            for (Edge e : graph.get(i)) {
                if (e.to == start && dist[i] != INF) {
                    minCycle = Math.min(minCycle, dist[i] + e.cost);
                }
            }
        }

        return minCycle;
    }
}
