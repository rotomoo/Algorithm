import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge implements Comparable<Edge> {
        int destination;
        int cost;

        public Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static List<List<Edge>> roadNetwork;
    static boolean[][] edgesToExclude;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int destinationNode = Integer.parseInt(st.nextToken());

            roadNetwork = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                roadNetwork.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                roadNetwork.get(u).add(new Edge(v, p));
            }

            List<List<Integer>> shortestPathPredecessors = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                shortestPathPredecessors.add(new ArrayList<>());
            }

            calculateShortestPaths(startNode, null, shortestPathPredecessors);
            
            edgesToExclude = new boolean[N][N];
            excludeShortestPathEdges(startNode, destinationNode, shortestPathPredecessors);

            List<Integer> almostShortestPathDistances = calculateShortestPaths(startNode, edgesToExclude, null);
            
            int result = almostShortestPathDistances.get(destinationNode);
            if (result == INF) {
                sb.append(-1).append("\n");
            } else {
                sb.append(result).append("\n");
            }
        }
        System.out.print(sb.toString());
    }
    
    private static void excludeShortestPathEdges(int startNode, int currentNode, List<List<Integer>> predecessors) {
        if (currentNode == startNode) {
            return;
        }
        for (int previousNode : predecessors.get(currentNode)) {
            if (!edgesToExclude[previousNode][currentNode]) {
                edgesToExclude[previousNode][currentNode] = true;
                excludeShortestPathEdges(startNode, previousNode, predecessors);
            }
        }
    }

    private static List<Integer> calculateShortestPaths(int startNode, boolean[][] edgesToExclude, List<List<Integer>> predecessors) {
        List<Integer> distances = new ArrayList<>(Collections.nCopies(N, INF));
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        distances.set(startNode, 0);
        pq.add(new Edge(startNode, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.destination;

            if (current.cost > distances.get(currentNode)) continue;

            for (Edge nextEdge : roadNetwork.get(currentNode)) {
                if (edgesToExclude != null && edgesToExclude[currentNode][nextEdge.destination]) {
                    continue;
                }

                int newDist = distances.get(currentNode) + nextEdge.cost;
                
                if (predecessors != null) { 
                    if (distances.get(nextEdge.destination) > newDist) {
                        distances.set(nextEdge.destination, newDist);
                        predecessors.get(nextEdge.destination).clear();
                        predecessors.get(nextEdge.destination).add(currentNode);
                        pq.add(new Edge(nextEdge.destination, newDist));
                    } else if (distances.get(nextEdge.destination) == newDist) {
                        predecessors.get(nextEdge.destination).add(currentNode);
                    }
                } else {
                    if (distances.get(nextEdge.destination) > newDist) {
                        distances.set(nextEdge.destination, newDist);
                        pq.add(new Edge(nextEdge.destination, newDist));
                    }
                }
            }
        }
        return distances;
    }
}