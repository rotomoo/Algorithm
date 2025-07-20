import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            System.out.println(checkPalindrome(s));
        }
    }

    private static int checkPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1, false);
    }

    private static int isPalindrome(String s, int left, int right, boolean skipped) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }

            if (skipped) return 2;

            int skipLeft = isPalindrome(s, left + 1, right, true);
            int skipRight = isPalindrome(s, left, right - 1, true);

            if (skipLeft == 0 || skipRight == 0) return 1;
            return 2;
        }
        return 0;
    }
}