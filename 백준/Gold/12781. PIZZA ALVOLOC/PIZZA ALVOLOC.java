import java.io.*;
import java.util.*;

public class Main {
    static class Coordinate {
        long x, y;
        
        public Coordinate(long x, long y) {
            this.x = x; 
            this.y = y; 
        }
    }

    private static long ccw(Coordinate c1, Coordinate c2, Coordinate c3) {
        long cross = (c2.x - c1.x) * (c3.y - c1.y) - (c2.y - c1.y) * (c3.x - c1.x);
        if (cross > 0) return 1;
        if (cross < 0) return -1;
        return 0;
    }

    private static boolean isProperIntersect(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4) {
        long ab1 = ccw(c1, c2, c3);
        long ab2 = ccw(c1, c2, c4);
        long cd1 = ccw(c3, c4, c1);
        long cd2 = ccw(c3, c4, c2);
        return (ab1 * ab2 < 0) && (cd1 * cd2 < 0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Coordinate c1 = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Coordinate c2 = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Coordinate c3 = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Coordinate c4 = new Coordinate(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        System.out.println(isProperIntersect(c1, c2, c3, c4) ? 1 : 0);
    }
}