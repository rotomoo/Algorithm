import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int count = 0;

        while (N-- > 0) {
            int half = 1 << N;
            int quadrantSize = half * half;

            if (r < half && c < half) {
            } else if (r < half && c >= half) {
                count += quadrantSize;
                c -= half;
            } else if (r >= half && c < half) {
                count += quadrantSize * 2;
                r -= half;
            } else {
                count += quadrantSize * 3;
                r -= half;
                c -= half;
            }
        }

        System.out.println(count);
    }
}