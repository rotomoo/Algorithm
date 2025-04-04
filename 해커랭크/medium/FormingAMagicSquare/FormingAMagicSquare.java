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

    static int[][] staticS;
    static int answer = Integer.MAX_VALUE;

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    private static boolean magicSqureYn(int[][] m) {
        int sum = m[0][0] + m[0][1] + m[0][2];

        for (int i = 0; i < 3; i++) {
            if (m[i][0] + m[i][1] + m[i][2] != sum) {
                return false;
            }
            if (m[0][i] + m[1][i] + m[2][i] != sum) {
                return false;
            }
        }

        if (m[0][0] + m[1][1] + m[2][2] != sum) {
            return false;
        }
        if (m[0][2] + m[1][1] + m[2][0] != sum) {
            return false;
        }

        return true;
    }

    private static int calcSum(int[][] currnetS) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += Math.abs(currnetS[i][j] - staticS[i][j]);
            }
        }
        return sum;
    }

    private static void dfs(int[][] currnetS, boolean[] used, int depth) {
        if (depth == 9) {
            if (magicSqureYn(currnetS)) {
                int sum = calcSum(currnetS);
                answer = Math.min(answer, sum);
            }
            return;
        }


        int row = depth / 3;
        int col = depth % 3;

        for (int value = 1; value <= 9; value++) {
            if (!used[value]) {
                used[value] = true;
                currnetS[row][col] = value;
                dfs(currnetS, used, depth + 1);
                used[value] = false;
            }
        }
    }

    public static int formingMagicSquare(List<List<Integer>> s) {
        // Write your code here
        staticS = new int[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                staticS[i][j] = s.get(i).get(j);
            }
        }

        int[][] currentS = new int[3][3];
        boolean[] used = new boolean[10];

        dfs(currentS, used, 0);

        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
