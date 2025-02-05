import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (;t >0; t--) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                double a = Integer.parseInt(st.nextToken());
                double b = Integer.parseInt(st.nextToken());
                double c = Integer.parseInt(st.nextToken());
                double x = a/c;
                if (x*b >= d) answer++;
            }
            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
    }
}
