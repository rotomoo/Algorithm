import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long lt = 1;
        long rt = k;
        long ans = 0;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(N, mid / i);
            }

            if (count >= k) {
                ans = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(ans);
    }
}