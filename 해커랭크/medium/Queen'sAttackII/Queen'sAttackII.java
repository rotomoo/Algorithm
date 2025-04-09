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

    static class Coordinate {
        int x;
        int y;
        int direction;

        public Coordinate(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static Set<String> obstacleSet;

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        obstacleSet = new HashSet<>();
        for (List<Integer> obs : obstacles) {
            obstacleSet.add(obs.get(0) + "," + obs.get(1));
        }
        int answer = 0;
        int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

        ArrayDeque<Coordinate> queue = new ArrayDeque<>();

        for (int i=0; i<8; i++) {
            queue.offer(new Coordinate(r_q, c_q, i));
        }

        while (!queue.isEmpty()) {
            Coordinate queenCoordinate = queue.poll();

            if (!(queenCoordinate.x == r_q && queenCoordinate.y == c_q)) {
                answer ++;
            }

            int nx = queenCoordinate.x + dx[queenCoordinate.direction];
            int ny = queenCoordinate.y + dy[queenCoordinate.direction];
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= n && !obstaclesYn(nx ,ny)) {
                queue.offer(new Coordinate(nx, ny, queenCoordinate.direction));
            }
        }

        return answer;
    }

    public static boolean obstaclesYn(int x, int y) {
        return obstacleSet.contains(x + "," + y);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
