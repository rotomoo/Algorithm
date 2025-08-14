import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (true) {
            if (t <= 0) break;

            int n = Integer.parseInt(br.readLine().trim());
            String[] nums = new String[n];
            for (int i = 0; i < n; i++) {
                nums[i] = br.readLine().trim();
            }

            Arrays.sort(nums);

            boolean ok = true;
            for (int i = 0; i + 1 < n; i++) {
                if (nums[i + 1].startsWith(nums[i])) {
                    ok = false;
                    break;
                }
            }
            out.append(ok ? "YES" : "NO").append('\n');
            t--;
        }
        System.out.print(out.toString());
    }
}