import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int mod=1000000;
        int tmp = mod/10*15;
        long[] dy= new long[tmp];
        dy[1]=1;
        for (int i=2; i<tmp && i<=n; i++) {
            dy[i]=(dy[i-2]+dy[i-1])%mod;
        }
        if (n>=tmp) n%=tmp;
        System.out.println(dy[(int)n]);
    }
}
