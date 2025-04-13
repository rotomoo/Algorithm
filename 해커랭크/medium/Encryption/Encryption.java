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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
        // Write your code here
        int length = s.length();
        double lengthSqrt = Math.sqrt(length);
        int row = (int) lengthSqrt;
        int column = row + 1;

        if (lengthSqrt % 1 == 0) {
            column --;
        }

        if (row * column < length) {
            row ++;
        }

        String answer = "";

        for (int i=0; i<column; i++) {
            for (int j=0; j<row; j++) {
                if (j * column + i > length - 1) {
                    break;
                }
                answer += s.charAt(j * column + i);
            }
            answer += " ";
        }
        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
