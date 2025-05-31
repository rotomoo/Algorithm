import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();

            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();
                graph.get(b).add(new Edge(a, s));
            }
            
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            
            int[] times = new int[n + 1];
            Arrays.fill(times, Integer.MAX_VALUE);
            times[c] = 0;
            
            pq.add(new Edge(c, 0));
            
            while (!pq.isEmpty()) {
                Edge nowEdge = pq.poll();
                
                if (nowEdge.weight > times[nowEdge.to]) {
                    continue;
                }
                
                for (Edge nextEdge : graph.get(nowEdge.to)) {
                    int newTime = times[nowEdge.to] + nextEdge.weight;
                    if (newTime < times[nextEdge.to]) {
                        times[nextEdge.to] = newTime;
                        pq.add(new Edge(nextEdge.to, newTime));
                    }
                }
            }
            
            int count = 0, maxTime = 0;
            for (int i = 1; i <= n; i++) {
                if (times[i] != Integer.MAX_VALUE) {
                    count++;
                    maxTime = Math.max(maxTime, times[i]);
                }
            }
            
            System.out.println(count + " " + maxTime);
            t --;
        }
    }
}