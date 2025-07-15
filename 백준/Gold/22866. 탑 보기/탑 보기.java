import java.util.*;

public class Main {

    static class Building {
        int index;
        int height;

        Building(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int[] visibleCount = new int[n];
        int[] closestIdx = new int[n];
        Arrays.fill(closestIdx, -1);

        Deque<Building> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekLast().height <= heights[i]) {
                deque.pollLast();
            }

            visibleCount[i] += deque.size();
            if (!deque.isEmpty()) {
                closestIdx[i] = deque.peekLast().index;
            }

            deque.offerLast(new Building(i + 1, heights[i]));
        }

        deque.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekLast().height <= heights[i]) {
                deque.pollLast();
            }

            visibleCount[i] += deque.size();
            if (!deque.isEmpty()) {
                int rightIdx = deque.peekLast().index;
                if (closestIdx[i] == -1) {
                    closestIdx[i] = rightIdx;
                } else {
                    int leftDist = Math.abs(i + 1 - closestIdx[i]);
                    int rightDist = Math.abs(i + 1 - rightIdx);
                    if (rightDist < leftDist || (rightDist == leftDist && rightIdx < closestIdx[i])) {
                        closestIdx[i] = rightIdx;
                    }
                }
            }

            deque.offerLast(new Building(i + 1, heights[i]));
        }

        for (int i = 0; i < n; i++) {
            if (visibleCount[i] == 0) {
                System.out.println(0);
            } else {
                System.out.println(visibleCount[i] + " " + closestIdx[i]);
            }
        }
    }
}