import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dy = new int[21];
        dy[1]=1;
        for (int i=2; i<=n; i++) {
            dy[i]=dy[i-1]+dy[i-2];
        }
        System.out.print(dy[n]);
    }
}
