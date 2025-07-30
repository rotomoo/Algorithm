import java.util.*;

public class Main {

    static class Rect {
        int x1, y1, x2, y2;

        Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        private boolean connectYn(Rect o) {
            if ((x1 < o.x1 && o.x2 < x2 && y1 < o.y1 && o.y2 < y2) ||
                (x1 > o.x1 && o.x2 > x2 && y1 > o.y1 && o.y2 > y2) ||
                 x2 < o.x1 || o.x2 < x1 || y2 < o.y1 || o.y2 < y1) {
                return false;
            }
            return true;
        }
    }

    static int N;
    static List<Rect> rects = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int originalN = sc.nextInt();
        N = originalN + 1; //
        visited = new boolean[N];

        rects.add(new Rect(0, 0, 0, 0));

        for (int i = 1; i < N; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            rects.add(new Rect(x1, y1, x2, y2));
        }

        int groupCount = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i);
                groupCount++;
            }
        }

        System.out.println(groupCount - 1);
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && rects.get(idx).connectYn(rects.get(i))) {
                dfs(i);
            }
        }
    }
}