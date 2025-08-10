import java.io.*;
import java.util.*;

public class Main {

    static class Coordinate {
        long x;
        long y;
        
        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static long ccw(Coordinate a, Coordinate b, Coordinate c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // L1: A, B
        st = new StringTokenizer(br.readLine());
        Coordinate a = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Coordinate b = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        // L2: C, D
        st = new StringTokenizer(br.readLine());
        Coordinate c = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Coordinate d = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        long ab_c = ccw(a, b, c);
        long ab_d = ccw(a, b, d);
        long cd_a = ccw(c, d, a);
        long cd_b = ccw(c, d, b);

        boolean abOpp = (ab_c > 0 && ab_d < 0) || (ab_c < 0 && ab_d > 0);
        boolean cdOpp = (cd_a > 0 && cd_b < 0) || (cd_a < 0 && cd_b > 0);

        System.out.println((abOpp && cdOpp) ? 1 : 0);
    }
}