import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        boolean[] visits = new boolean[V + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        int total = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int node = cur.to;
            int weight = cur.weight;
            if (visits[node]) continue;
            visits[node] = true;
            total += weight;

            for (Edge next : graph.get(node)) {
                if (!visits[next.to]) pq.add(next);
            }
        }

        System.out.println(total);
    }
}