import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n%2==0) System.out.println((int)Math.pow(n/2+1,2));
        else System.out.println((n/2+1)*(n/2+2));
    }
}
