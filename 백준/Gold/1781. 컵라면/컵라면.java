import java.io.*;
import java.util.*;

public class Main {

    static class Problem implements Comparable<Problem> {
        final int deadline;
        final int ramen;

        Problem(int deadline, int ramen) {
            this.deadline = deadline;
            this.ramen = ramen;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.deadline != o.deadline) {
                return this.deadline - o.deadline;
            }
            return this.ramen - o.ramen;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Problem> problems = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            problems.add(new Problem(d, r));
        }

        Collections.sort(problems);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Problem p : problems) {
            minHeap.offer(p.ramen);
            if (minHeap.size() > p.deadline) {
                minHeap.poll();
            }
        }

        long sum = 0L;
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll();
        }

        System.out.println(sum);
    }
}