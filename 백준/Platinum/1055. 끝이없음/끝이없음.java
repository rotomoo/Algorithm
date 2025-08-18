import java.io.*;
import java.util.*;

public class Main {
    static String init, pattern;
    static char[] S;
    static long n, from, to, cap;
    static ArrayList<Long> lens;

    private static char getCharA1(long pos, String left, String right) {
        long L0 = init.length();
        long leftLen = left.length();
        long rightLen = right.length();

        long leftTotal = leftLen * n;
        if (leftLen > 0 && pos <= leftTotal) {
            int idx = (int)((pos - 1) % leftLen);
            return left.charAt(idx);
        }
        pos -= Math.min(pos, leftTotal);

        if (pos <= L0) return init.charAt((int)pos - 1);
        pos -= L0;

        long rightTotal = rightLen * n;
        if (rightLen > 0 && pos <= rightTotal) {
            int idx = (int)((pos - 1) % rightLen);
            return right.charAt(idx);
        }
        return '-';
    }

    private static char getChar(int i, long pos) {
        if (i == 0) {
            if (pos <= init.length()) return init.charAt((int)pos - 1);
            return '-';
        }
        long remain = pos;
        for (char c : S) {
            if (c == '$') {
                long prevLen = lenOf(i - 1);
                if (remain <= prevLen) {
                    return getChar(i - 1, remain);
                } else {
                    remain -= prevLen;
                }
            } else {
                if (remain == 1) return c;
                remain--;
            }
        }
        return '-';
    }

    private static long lenOf(int i) {
        int last = lens.size() - 1;
        if (i <= last) return lens.get(i);
        return lens.get(last);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init = br.readLine().trim();
        pattern = br.readLine().trim();
        n = Long.parseLong(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        from = Long.parseLong(st.nextToken());
        to = Long.parseLong(st.nextToken());

        cap = to;

        int a = 0, b = 0;
        for (char c : pattern.toCharArray()) {
            if (c == '$') a++;
            else b++;
        }
        S = pattern.toCharArray();

        StringBuilder out = new StringBuilder();

        if (a == 1) {
            int idxDollar = pattern.indexOf('$');
            String left = pattern.substring(0, idxDollar);
            String right = pattern.substring(idxDollar + 1);
            for (long p = from; p <= to; p++) {
                out.append(getCharA1(p, left, right));
            }
            System.out.println(out);
            return;
        }

        lens = new ArrayList<>();
        lens.add((long) init.length()); // L0
        int T = 0;
        while (true) {
            if (T >= n) break;
            long prev = lens.get(T);
            // L_{i+1} = a*prev + b with cap
            long next = a * prev + b;
            if (next > cap) next = cap;
            lens.add(next);
            T++;
            if (next == cap) break;
        }
        int i0;
        if (n <= T) i0 = (int) n;
        else i0 = T; 

        for (long p = from; p <= to; p++) {
            out.append(getChar(i0, p));
        }
        System.out.println(out);
    }
}