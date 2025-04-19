import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    int st, et;
    Point(int st, int et) {
        this.st=st;
        this.et=et;
    }

    @Override
    public int compareTo(Point o) {
        if (this.et==o.et) return this.st-o.st;
        else return this.et-o.et;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            st=new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            list.add(new Point(a,b));
        }
        Collections.sort(list);
        int answer=0, et=0;
        for (Point x : list) {
            if (x.st>=et) {
                answer++;
                et=x.et;
            }
        }
        System.out.print(answer);
    }
}
