import java.util.*;

public class Main {
    
    static class Node {
        int position;
        int count;

        public Node(int position, int count) {
            this.position = position;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] move = new int[101];
        boolean[] visited = new boolean[101];

        for (int i = 1; i <= 100; i++) {
            move[i] = i;
        }

        int ladder = sc.nextInt();
        int snake = sc.nextInt();

        for (int i = 0; i < ladder + snake; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            move[from] = to;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.position == 100) {
                System.out.println(cur.count);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = cur.position + dice;
                if (next > 100) continue;

                int dest = move[next];
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.add(new Node(dest, cur.count + 1));
                }
            }
        }
    }
}