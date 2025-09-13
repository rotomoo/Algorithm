import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] s = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int oddCount = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {
            if (s[right] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > k) {
                if (s[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }
            
            int currentLength = (right - left + 1) - oddCount;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
        }

        System.out.println(maxLength);
    }
}