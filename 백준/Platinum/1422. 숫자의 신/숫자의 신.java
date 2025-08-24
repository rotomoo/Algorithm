import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<String> numbers = new ArrayList<>();
        int maxNumInt = Integer.MIN_VALUE;
        String maxNumString = "";

        for (int i = 0; i < k; i++) {
            String current = br.readLine().trim();
            numbers.add(current);
            int value = Integer.parseInt(current);
            if (value > maxNumInt) {
                maxNumInt = value;
                maxNumString = current;
            }
        }

        int addCount = n - k;
        for (int i = 0; i < addCount; i++) {
            numbers.add(maxNumString);
        }

        numbers.sort((a, b) -> (b + a).compareTo(a + b));

        StringBuilder result = new StringBuilder();
        numbers.forEach(num -> result.append(num));

        System.out.println(result.toString());
    }
}