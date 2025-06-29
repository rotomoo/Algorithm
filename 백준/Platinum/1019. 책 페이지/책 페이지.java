import java.io.*;

public class Main {
    static long[] counts = new long[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long digit = 1;
        long start = 1;
        long end = Long.parseLong(br.readLine());

        while (start <= end) {
            // end의 1의 자리가 9가 되도록 감소시키며 개별 처리 end = 123 -> 119
            while (end % 10 != 9 && start <= end) {
                addNumber(end, digit);
                end--;
            }

            // start의 1의 자리가 0이 되도록 증가시키며 개별 처리 start = 1 -> 10
            while (start % 10 != 0 && start <= end) {
                addNumber(start, digit);
                start++;
            }

            if (start > end) break;

            // 자릿수 처리 (119/10 - 10/10 + 1) * digit 10~19 -> 110~119 총 11묶음
            long cnt = (end / 10 - start / 10 + 1);
            for (int i = 0; i < 10; i++) {
                counts[i] += cnt * digit;
            }

            // 다음 자리수로 이동
            start /= 10;
            end /= 10;
            digit *= 10;
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(counts[i] + " ");
        }
    }

    // 한 숫자의 각 자릿수에 대해 등장 횟수 누적
    private static void addNumber(long num, long digit) {
        while (num > 0) {
            int d = (int)(num % 10);
            counts[d] += digit;
            num /= 10;
        }
    }
}