import java.util.*;
import java.io.*;

public class Main {
    static class Tower {
        int index;
        int height;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answers = new int[N+1];
        int[] heights = new int[N+1];
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Tower> stack = new ArrayDeque<>();

        for (int index = 1; index <= N; index++) {
            int currentHeight = heights[index];

            while (!stack.isEmpty() && stack.peekLast().height < currentHeight) {
                stack.pollLast();
            }

            if (!stack.isEmpty()) {
                answers[index] = stack.peekLast().index;
            } else {
                answers[index] = 0;
            }

            stack.offerLast(new Tower(index, currentHeight));
        }

        StringBuilder sb = new StringBuilder();

        for (int index = 1; index <= N; index++) {
            sb.append(answers[index]).append(" ");
        }

        System.out.println(sb.toString());
    }
}