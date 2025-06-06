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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> deduplicatedRanked = new ArrayList<>(new LinkedHashSet<>(ranked));
        List<Integer> answer = new ArrayList<>();

        for (Integer p : player) {
            int ltIdx = 0;
            int rtIdx = deduplicatedRanked.size() - 1;
            int midIdx = 0;

            while (ltIdx <= rtIdx) {
                midIdx = (ltIdx + rtIdx) / 2;
                if (p == deduplicatedRanked.get(midIdx)) {
                    break;
                }
                else if (p < deduplicatedRanked.get(midIdx)) {
                    ltIdx = midIdx + 1;
                }
                else {
                    rtIdx = midIdx - 1;
                }
            }

            int rank = midIdx + 1;

            if (p >= deduplicatedRanked.get(midIdx)) {
                answer.add(rank);
            }
            else if (p < deduplicatedRanked.get(midIdx)) {
                answer.add(rank + 1);
            }
        }
        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
