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
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
    // Write your code here

        String hourWord = getWord(h);
        String nextHourWord = getWord(h == 12 ? 1 : h + 1);
        String minuteWord = getWord(m);
        String result = "";

        switch (m) {
            case 0:
                result = hourWord + " o' clock";
                break;
            case 15:
                result = "quarter past " + hourWord;
                break;
            case 30:
                result = "half past " + hourWord;
                break;
            case 45:
                result = "quarter to " + nextHourWord;
                break;
            default:
                if (m < 30) {
                    result = getWord(m) + " minute" + (m == 1 ? "" : "s") + " past " + hourWord;
                } else {
                    int toMin = 60 - m;
                    result = getWord(toMin) + " minute" + (toMin == 1 ? "" : "s") + " to " + nextHourWord;
                }
        }

        return result;
    }

    static String getWord(int n) {
        switch (n) {
            case 1:  return "one";
            case 2:  return "two";
            case 3:  return "three";
            case 4:  return "four";
            case 5:  return "five";
            case 6:  return "six";
            case 7:  return "seven";
            case 8:  return "eight";
            case 9:  return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            case 20: return "twenty";
            case 21: return "twenty one";
            case 22: return "twenty two";
            case 23: return "twenty three";
            case 24: return "twenty four";
            case 25: return "twenty five";
            case 26: return "twenty six";
            case 27: return "twenty seven";
            case 28: return "twenty eight";
            case 29: return "twenty nine";
            default: return "";
    }
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
