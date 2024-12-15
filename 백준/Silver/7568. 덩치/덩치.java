import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int we, he;
        Point(int we, int he) {
            this.we = we;
            this.he = he;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Point> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int[] answer = new int[n];
        for (int i=0; i<n; i++) {
            int score = 1;
            for (int j=0; j<n; j++) {
                if (list.get(i).he < list.get(j).he && list.get(i).we < list.get(j).we) {
                    score++;
                }
            }
            answer[i] = score;
        }
        for (int x : answer) System.out.print(x+" ");
    }
}
