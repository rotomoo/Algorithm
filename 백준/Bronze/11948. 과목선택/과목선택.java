import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tmp1 = Integer.MAX_VALUE;
        int tmp2 = Integer.MAX_VALUE;
        int answer = 0;
        for (int i=0; i<4; i++) {
            int a = Integer.parseInt(br.readLine());
            answer += a;
            tmp1 = Math.min(tmp1, a);
        }
        for (int i=0; i<2; i++) {
            int a = Integer.parseInt(br.readLine());
            answer += a;
            tmp2 = Math.min(tmp2, a);
        }
        answer -= (tmp1+tmp2);
        System.out.println(answer);
    }
}
