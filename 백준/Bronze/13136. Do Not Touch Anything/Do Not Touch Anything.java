import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long answer=1;
        if (x%n==0) answer*=x/n;
        else answer*=x/n+1;
        if (y%n==0) answer*=y/n;
        else answer*=y/n+1;
        System.out.println(answer);
    }
}
