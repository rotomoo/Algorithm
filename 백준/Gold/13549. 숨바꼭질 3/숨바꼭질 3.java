import java.util.*;

public class Main {
    static final int MAX = 100_001;

    static class Node implements Comparable<Node> {
        int pos;
        int time;

        Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        public int compareTo(Node other) {
            return this.time - other.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] times = new int[MAX];
        Arrays.fill(times, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(n, 0));
        times[n] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            
            if (curNode.pos == k) {
                System.out.println(curNode.time);
                return;
            }
            
            // 이미 더 좋은 경로가 있다면
            if (curNode.time > times[curNode.pos]) {
                continue;
            }
            
            int[] nextPositions = {curNode.pos + 1, curNode.pos - 1, curNode.pos * 2};

            for (int i=0; i<3; i++) {
                int nextPos = nextPositions[i];
                if (nextPos >= 0 && nextPos < MAX) {
                    int addTime = i == 2 ? 0 : 1;
                    int nextTime = curNode.time + addTime;
                    if (times[nextPos] > nextTime) {
                        times[nextPos] = nextTime;
                        pq.offer(new Node(nextPos, nextTime));
                    }
                }
            }
        }
    }
}