import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            if (maxHeap.size()==minHeap.size()) maxHeap.offer(Integer.parseInt(br.readLine()));
            else minHeap.offer(Integer.parseInt(br.readLine()));
            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek()>minHeap.peek()) {
                    int tmp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);
                }
            }
            bw.write(maxHeap.peek()+"\n");
        }
        bw.flush();
        bw.close();
    }
}
