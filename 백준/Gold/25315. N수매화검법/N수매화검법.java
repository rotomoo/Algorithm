import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class LineSegment implements Comparable<LineSegment> {
        long sx, sy, ex, ey, weight;

        LineSegment(long weight, long sx, long sy, long ex, long ey) {
            this.weight = weight;
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }

        @Override
        public int compareTo(LineSegment other) {
            return Long.compare(this.weight, other.weight);
        }
    }

    static int ccw(long ax, long ay, long bx, long by, long cx, long cy) {
        long t = (ax - bx) * (cy - by) - (ay - by) * (cx - bx);
        return Long.compare(t, 0);
    }

    static boolean cross(LineSegment a, LineSegment b) {
        int abc = ccw(a.sx, a.sy, a.ex, a.ey, b.sx, b.sy);
        int abd = ccw(a.sx, a.sy, a.ex, a.ey, b.ex, b.ey);
        int cda = ccw(b.sx, b.sy, b.ex, b.ey, a.sx, a.sy);
        int cdb = ccw(b.sx, b.sy, b.ex, b.ey, a.ex, a.ey);

        if (abc * abd == 0 && cda * cdb == 0) {
            if (Math.max(a.sx, a.ex) < Math.min(b.sx, b.ex) || Math.max(b.sx, b.ex) < Math.min(a.sx, a.ex) ||
                Math.max(a.sy, a.ey) < Math.min(b.sy, b.ey) || Math.max(b.sy, b.ey) < Math.min(a.sy, a.ey)) {
                return false;
            }
            return true;
        }
        return abc * abd <= 0 && cda * cdb <= 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<LineSegment> segments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            segments.add(new LineSegment(weight, sx, sy, ex, ey));
        }

        Collections.sort(segments);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long m = 0;
            for (int j = i + 1; j < n; j++) {
                if (cross(segments.get(i), segments.get(j))) m++; // 교차점 개수 count
            }
            ans += (m + 1) * segments.get(i).weight;
        }

        System.out.println(ans);
    }
}