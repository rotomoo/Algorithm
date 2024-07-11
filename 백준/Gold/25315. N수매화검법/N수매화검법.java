import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long answer;
    static List<Sword> swords;

    static class Sword implements Comparable<Sword> {

        long sx, sy, ex, ey, w;

        public Sword(long sx, long sy, long ex, long ey, long w) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
            this.w = w;
        }

        public Boolean crossYn(Sword targetSword) {
            int ccw1 = ccw(this.sx, this.sy, this.ex, this.ey, targetSword.sx, targetSword.sy);
            int ccw2 = ccw(this.sx, this.sy, this.ex, this.ey, targetSword.ex, targetSword.ey);
            int ccw3 = ccw(targetSword.sx, targetSword.sy, targetSword.ex, targetSword.ey, this.sx, this.sy);
            int ccw4 = ccw(targetSword.sx, targetSword.sy, targetSword.ex, targetSword.ey, this.ex, this.ey);

            if (ccw1 * ccw2 == 0 && ccw3 * ccw4 == 0) {
                if (Math.max(this.sx, this.ex) < Math.min(targetSword.sx, targetSword.ex) || Math.max(targetSword.sx, targetSword.ex) < Math.min(this.sx, this.ex) ||
                    Math.max(this.sy, this.ey) < Math.min(targetSword.sy, targetSword.ey) || Math.max(targetSword.sy, targetSword.ey) < Math.min(this.sy, this.ey)) {
                    return false;
                }
                return true;
            }
            return ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0;
        }

        private int ccw(long ax, long ay, long bx, long by, long cx, long cy) {
            long area = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
            return Long.compare(area, 0);
        }

        @Override
        public int compareTo(Sword o) {
            return Long.compare(this.w, o.w);
        }
    }

    public static void cut() {
        for (int i = 0; i < swords.size(); i++) {
            int m = 0;
            Sword sword = swords.get(i);
            for (int j = i + 1; j < swords.size(); j++) {
                Sword sword2 = swords.get(j);
                if (sword.crossYn(sword2)) {
                    m++;
                }
            }
            answer += (m + 1) * sword.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;

        swords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            swords.add(new Sword(
                Long.parseLong(st.nextToken()),
                Long.parseLong(st.nextToken()),
                Long.parseLong(st.nextToken()),
                Long.parseLong(st.nextToken()),
                Long.parseLong(st.nextToken())
            ));
        }

        Collections.sort(swords);

        cut();

        System.out.println(answer);
    }
}