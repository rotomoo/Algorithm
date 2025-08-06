import java.util.*;

public class Main {

    static class Coordinate {
        public int x;
        public int y;
        
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Segment {
        public Coordinate p1;
        public Coordinate p2;
        
        public Segment(int x1, int y1, int x2, int y2) {
            p1 = new Coordinate(x1, y1);
            p2 = new Coordinate(x2, y2);
        }
    }

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static Segment[] segs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        segs = new Segment[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            segs[i] = new Segment(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersectYn(segs[i], segs[j])) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        int groupCount = 0;
        int maxGroupSize = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i);
                groupCount++;
                maxGroupSize = Math.max(maxGroupSize, size);
            }
        }

        System.out.println(groupCount);
        System.out.println(maxGroupSize);
    }

    private static int dfs(int curr) {
        visited[curr] = true;
        int count = 1;
        for (int next : graph.get(curr)) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }
        return count;
    }

    private static int ccw(Coordinate a, Coordinate b, Coordinate c) {
        long res = (long)(b.x - a.x) * (c.y - a.y) - (long)(b.y - a.y) * (c.x - a.x);
        return Long.compare(res, 0);
    }

    private static boolean intersectYn(Segment s1, Segment s2) {
        Coordinate A = s1.p1, B = s1.p2;
        Coordinate C = s2.p1, D = s2.p2;

        int ab = ccw(A, B, C) * ccw(A, B, D);
        int cd = ccw(C, D, A) * ccw(C, D, B);

        if (ab == 0 && cd == 0) {
            if (Math.max(A.x, B.x) < Math.min(C.x, D.x)) return false;
            if (Math.max(C.x, D.x) < Math.min(A.x, B.x)) return false;
            if (Math.max(A.y, B.y) < Math.min(C.y, D.y)) return false;
            if (Math.max(C.y, D.y) < Math.min(A.y, B.y)) return false;
            return true;
        }

        return ab <= 0 && cd <= 0;
    }
}