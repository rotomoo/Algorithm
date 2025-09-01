import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static class RouteInterval implements Comparable<RouteInterval> {
        int start;
        int end;
        int id;

        public RouteInterval(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        @Override
        public int compareTo(RouteInterval other) {
            if (this.start != other.start) {
                return this.start - other.start;
            }
            return other.end - this.end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<RouteInterval> intervals = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (a < b) {
                intervals.add(new RouteInterval(a, b, i));
                intervals.add(new RouteInterval(a + n, b + n, i));
            } else {
                intervals.add(new RouteInterval(a, b + n, i));
            }
        }

        Collections.sort(intervals);

        boolean[] cancelYns = new boolean[m + 1];
        int maxEnd = -1;

        for (RouteInterval current : intervals) {
            if (current.end <= maxEnd) {
                cancelYns[current.id] = true;
            } else {
                maxEnd = current.end;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            if (!cancelYns[i]) {
                sb.append(i).append(" ");
            }
        }
        
        System.out.println(sb.toString().trim());
        sc.close();
    }
}