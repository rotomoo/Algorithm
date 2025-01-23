import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 44033-(int)(br.readLine().charAt(0));
        if (answer < 0) {
            System.out.println(Math.abs(answer)+2);
            System.exit(0);
        }
        System.out.println(answer);
    }
}
