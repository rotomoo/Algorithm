import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            long[] heights = new long[n + 1];
            for (int i = 0; i < n; i++) {
                heights[i] = Long.parseLong(st.nextToken());
            }
            heights[n] = 0;

            Deque<Integer> stack = new ArrayDeque<>();
            long maxArea = 0;

            for (int i = 0; i <= n; i++) {
                while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                    long height = heights[stack.pollLast()];
                    int width = stack.isEmpty() ? i : i - stack.peekLast() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.offerLast(i);
            }

            sb.append(maxArea).append("\n");
        }

        System.out.print(sb);
    }
}