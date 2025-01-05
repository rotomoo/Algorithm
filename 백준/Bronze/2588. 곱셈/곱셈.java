import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        for (int i=0; i<String.valueOf(m).length(); i++) {
            System.out.println(n * (String.valueOf(m).charAt(String.valueOf(m).length()-i-1)-'0'));
        }
        System.out.println(n*m);
    }
}
