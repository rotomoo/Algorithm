import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tmp = 0;
        for (int i=0; i<4; i++) {
            tmp += Integer.parseInt(br.readLine());
        }
//        String answer = LocalTime.MIN.plus(Duration.ofMinutes(tmp)).toString();
//        System.out.println(answer);
        System.out.println(tmp/60);
        System.out.println(tmp%60);
    }
}
