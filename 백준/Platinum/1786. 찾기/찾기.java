import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] createPatternLps(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];

        int i = 1;
        int len = 0;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    private static void kmpSearch(String target, String pattern) {
        int[] lps = createPatternLps(pattern);
        int n = target.length();
        int pn = pattern.length();

        int ti = 0;
        int pi = 0;

        int num = 0;
        StringBuilder sb = new StringBuilder();

        while (ti < n) {
            if (target.charAt(ti) == pattern.charAt(pi)) {
                ti++;
                pi++;
            }

            if (pi == pn) {
                num++;
                sb.append(ti - pi + 1).append(' ');
                pi = lps[pi - 1];
            } else if (ti < n && target.charAt(ti) != pattern.charAt(pi)) {
                if (pi != 0) {
                    pi = lps[pi - 1];
                } else {
                    ti++;
                }
            }
        }

        System.out.println(num);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String pattern = br.readLine();

        kmpSearch(target, pattern);
    }

}
