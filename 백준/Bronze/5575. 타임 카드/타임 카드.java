import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken())*3600+Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken())*3600+Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
            int s = s2-s1;
            int m = s/60;
            int h = m/60;
            System.out.println(h%24+" "+m%60+" "+s%60);
        }
    }
}
