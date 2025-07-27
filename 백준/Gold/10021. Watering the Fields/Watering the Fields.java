import java.util.*;

public class Main {
    static class Field {
        int x, y;
        Field(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node implements Comparable<Node> {
        int idx;
        long cost;

        Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    static int N;
    static long C;
    static Field[] fields;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        C = sc.nextLong();

        fields = new Field[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            fields[i] = new Field(x, y);
        }

        System.out.println(findPipe());
    }

    private static long findPipe() {
        visited = new boolean[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        long totalCost = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (visited[current.idx])
                continue;

            visited[current.idx] = true;
            totalCost += current.cost;
            count++;

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    long dist = distanceSquared(fields[current.idx], fields[i]);
                    if (dist >= C) {
                        pq.add(new Node(i, dist));
                    }
                }
            }
        }

        return count == N ? totalCost : -1;
    }

    private static long distanceSquared(Field a, Field b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }
}