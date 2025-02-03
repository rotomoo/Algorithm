import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        int tmp = b-a;
        if (a>0) {
            d = 0;
            c = 0;
        }
        else if (a==0) {
            c = 0;
        }
        else tmp = b;
        System.out.println((0-a)*c+d+(tmp)*e);
    }
}
