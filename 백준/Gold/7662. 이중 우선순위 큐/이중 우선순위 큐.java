import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        long v;
        int id;
        Node(long v, int id) {
            this.v = v;
            this.id = id;
        }
    }

    private static void clean(PriorityQueue<Node> q, boolean[] visited) {
        while (!q.isEmpty() && visited[q.peek().id]) {
            q.poll();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Node> minQ = new PriorityQueue<>((a, b) -> Long.compare(a.v, b.v));
            PriorityQueue<Node> maxQ = new PriorityQueue<>((a, b) -> Long.compare(b.v, a.v));
            boolean[] visited = new boolean[k];
            int idSeq = 0;

            for (int i = 0; i < k; i++) {
                String line = br.readLine();
                
                if (line == null || line.isEmpty()) {
                    i--;
                    continue; 
                }
                
                char op = line.charAt(0);

                if (op == 'I') {
                    long n = Long.parseLong(line.substring(2).trim());
                    Node node = new Node(n, idSeq);
                    minQ.add(node);
                    maxQ.add(node);
                    idSeq++;
                } else { // 'D'
                    int which = Integer.parseInt(line.substring(2).trim());
                    if (which == 1) {
                        clean(maxQ, visited);
                        if (!maxQ.isEmpty()) {
                            visited[maxQ.peek().id] = true;
                            maxQ.poll();
                        }
                    } else { // -1
                        clean(minQ, visited);
                        if (!minQ.isEmpty()) {
                            visited[minQ.peek().id] = true;
                            minQ.poll();
                        }
                    }
                }
            }

            clean(minQ, visited);
            clean(maxQ, visited);

            if (minQ.isEmpty() || maxQ.isEmpty()) {
                out.append("EMPTY\n");
            } else {
                out.append(maxQ.peek().v).append(' ').append(minQ.peek().v).append('\n');
            }
        }

        System.out.print(out.toString());
    }
}