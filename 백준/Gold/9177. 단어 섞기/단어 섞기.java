import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String s1 = sc.next();
            String s2 = sc.next();
            String s3 = sc.next();

            boolean result = canInterleaveYn(s1, s2, s3);
            System.out.println("Data set " + t + ": " + (result ? "yes" : "no"));
        }
    }

    private static boolean canInterleaveYn(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();

        if (s3.length() != n + m) return false;

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int k = i + j;
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(k - 1))
                    dp[i][j] |= dp[i - 1][j];
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(k - 1))
                    dp[i][j] |= dp[i][j - 1];
            }
        }

        return dp[n][m];
    }
}