import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int cnt=0;
        while (cnt < 9) {
            String tmp = String.valueOf((n.charAt(0)-'0') * n.length());
            if (tmp.length()==1) {
                System.out.println("FA");
                break;
            }
            n = tmp;
            cnt++;
        }
    }
}
