import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] heights = new long[N + 1]; // sentinel

        for (int i = 0; i < N; i++) {
            heights[i] = Long.parseLong(br.readLine());
        }
        heights[N] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        long maxArea = 0;

        for (int i = 0; i <= N; i++) {
            while (!dq.isEmpty() && heights[dq.peekLast()] > heights[i]) {
                long height = heights[dq.pollLast()];
                int width = dq.isEmpty() ? i : i - dq.peekLast() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            dq.offerLast(i);
        }

        System.out.println(maxArea);
    }
}
