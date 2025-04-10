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
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        List<Long> totalContainerBallCnts = new ArrayList<>();
        List<Long> totalBallColorCnts = new ArrayList<>();

        for (int i=0; i<container.size(); i++) {
            long totalContainerBallCnt = 0L;
            long totalBallColorCnt = 0L;
            for (int j=0; j<container.get(i).size(); j++) {
                totalContainerBallCnt += container.get(i).get(j);
                totalBallColorCnt += container.get(j).get(i);
            }
            totalContainerBallCnts.add(totalContainerBallCnt);
            totalBallColorCnts.add(totalBallColorCnt);
        }

        Collections.sort(totalContainerBallCnts);
        Collections.sort(totalBallColorCnts);

        for (int i=0; i<totalContainerBallCnts.size(); i++) {
            if (!totalContainerBallCnts.get(i).equals(totalBallColorCnts.get(i))) {
                return "Impossible";
            }
        }
        return "Possible";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
