import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'surfaceArea' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY A as parameter.
     */

    public static int surfaceArea(List<List<Integer>> A) {
        // Write your code here
        int answer = 0;
        int h = A.size();
        int w = A.get(0).size();

        for (int i=0; i<h; i++) {
            for (int j=0; j<w; j++) {
                answer += 2; // top, bottom
                answer += i > 0 ? Math.max(0, A.get(i).get(j) - A.get(i-1).get(j)) : A.get(i).get(j); //n
                answer += i < h - 1 ? Math.max(0, A.get(i).get(j) - A.get(i+1).get(j)) : A.get(i).get(j); //s
                answer += j > 0 ? Math.max(0, A.get(i).get(j) - A.get(i).get(j-1)) : A.get(i).get(j); //w
                answer += j < w - 1 ? Math.max(0, A.get(i).get(j) - A.get(i).get(j+1)) : A.get(i).get(j); //e
            }
        }

        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
