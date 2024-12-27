import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger k = new BigInteger(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] ch = new int[l+1];
        for (int i=2; i<l; i++) {
            if (ch[i]==1) continue;
            if (k.mod(BigInteger.valueOf(i)).toString().equals("0")) {
                System.out.println("BAD"+" "+i);
                System.exit(0);
            }
            for (int j = i; j<=l; j+=i) {
                ch[j]=1;
            }
        }
        System.out.println("GOOD");
    }
}
