import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dy = new int[k+1];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int pw = Integer.parseInt(st.nextToken());
            int pv = Integer.parseInt(st.nextToken());
            for (int j=k; j>=pw; j--) {
                dy[j]=Math.max(dy[j],dy[j-pw]+pv);
            }
        }
        System.out.print(dy[k]);
    }
}
