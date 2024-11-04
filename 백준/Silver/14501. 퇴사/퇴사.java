import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dy = new int[n+2];
        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pt = Integer.parseInt(st.nextToken());
            int pm = Integer.parseInt(st.nextToken());
            for (int j=n+1; pt+i<=n+1 && j>=pt+i; j--) {
                dy[j]=Math.max(dy[j],dy[i]+pm);
            }
        }
        System.out.print(dy[n+1]);
    }
}