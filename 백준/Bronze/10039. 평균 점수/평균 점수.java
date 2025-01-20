import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for (int i=0; i<5; i++) {
            int tmp = Integer.parseInt(br.readLine());
            answer += tmp >=40 ? tmp : 40;
        }
        System.out.println(answer/5);
    }
}
