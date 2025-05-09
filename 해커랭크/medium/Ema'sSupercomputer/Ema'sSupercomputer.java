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

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int row;
    static int column;

    static class Plus {
        int x;
        int y;
        int size;

        public Plus(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        public Set<String> getCells() {
            Set<String> cells = new HashSet<>();
            int cnt = (size - 1) / 4;
            while (cnt > -1) {
                for (int i=0; i<4; i++) {
                    int nx = dx[i] * cnt + x;
                    int ny = dy[i] * cnt + y;
                    cells.add(nx + "," + ny);
                }
                cnt --;
            }
            return cells;
        }

        public boolean duplicateYn(Plus otherPlus) {
            Set<String> thisCells = getCells();
            for (String otherCell : otherPlus.getCells()) {
                if(thisCells.contains(otherCell)) {
                    return true;
                }
            }

            return false;
        }
    }
    /*
     * Complete the 'twoPluses' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY grid as parameter.
     */
    public static int twoPluses(List<String> grid) {
        // Write your code here
        row = grid.size();
        column = grid.get(0).length();

        map = new char[row][column];

        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                map[i][j] = grid.get(i).charAt(j);
            }
        }

        List<Plus> pluses = new ArrayList<>();

        for (int x=0; x<row; x++) {
            for (int y=0; y<column; y++) {
                if (map[x][y] == 'G') {
                    pluses.add(new Plus(x, y, 1));
                    int len = 1;
                    while (plusYn(x, y, len)) {
                        pluses.add(new Plus(x, y, len * 4 + 1));
                        len ++;
                    }
                }
            }
        }

        int answer = 0;

        for (int i=0; i<pluses.size(); i++) {
            for (int j= i+1; j<pluses.size(); j++) {
                if (!pluses.get(i).duplicateYn(pluses.get(j))) {
                    int thisSize = pluses.get(i).size;
                    int otherSize = pluses.get(j).size;
                    answer = Math.max(answer, thisSize * otherSize);
                }
            }
        }

        return answer;
    }

    public static boolean plusYn(int x, int y, int len) {
        for (int i=0; i<4; i++) {
            int nx = dx[i] * len + x;
            int ny = dy[i] * len + y;
            if (nx < 0 || nx >= row || ny < 0 || ny >= column || map[nx][ny] == 'B') {
                return false;
            }
        }
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());

        int result = Result.twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
