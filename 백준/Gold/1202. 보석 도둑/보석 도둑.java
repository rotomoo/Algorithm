import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point> {
        int m, v;
        Point(int m, int v) {
            this.m=m;
            this.v=v;
        }

        @Override
        public int compareTo(Point o) {
            return this.m-o.m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] c = new int[k];
        ArrayList<Point> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Point(a,b));
        }
        for (int i=0; i<k; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }
        Collections.sort(list);
        Arrays.sort(c);
        //for (int x : c) System.out.println(x);
        //for (Point x : list) System.out.println(x.m+" "+x.v);
        long answer=0;
        int j=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<k; i++) {
            for (; j<n; j++) {
                if (list.get(j).m>c[i]) break;
                pq.offer(list.get(j).v);
            }
            if (!pq.isEmpty()) {
                answer+=pq.poll();
            }
        }
        System.out.print(answer);
    }
}
