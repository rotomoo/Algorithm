import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static class Problem implements Comparable<Problem> {
        int number;
        int level;

        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }

        @Override
        public int compareTo(Problem other) {
            if (this.level != other.level) {
                return this.level - other.level;
            }
            return this.number - other.number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder outputBuilder = new StringBuilder();

        TreeSet<Problem> sortedProblems = new TreeSet<>();
        Map<Integer, Integer> problemDifficulties = new HashMap<>();

        int initialProblemCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < initialProblemCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int number = Integer.parseInt(stringTokenizer.nextToken());
            int level = Integer.parseInt(stringTokenizer.nextToken());
            
            sortedProblems.add(new Problem(number, level));
            problemDifficulties.put(number, level);
        }

        int commandCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < commandCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();

            switch (command) {
                case "add" -> {
                    int number = Integer.parseInt(stringTokenizer.nextToken());
                    int level = Integer.parseInt(stringTokenizer.nextToken());
                    sortedProblems.add(new Problem(number, level));
                    problemDifficulties.put(number, level);
                }
                case "solved" -> {
                    int number = Integer.parseInt(stringTokenizer.nextToken());
                    int level = problemDifficulties.get(number);
                    sortedProblems.remove(new Problem(number, level));
                    problemDifficulties.remove(number);
                }
                case "recommend" -> {
                    int recommendType = Integer.parseInt(stringTokenizer.nextToken());
                    if (recommendType == 1) {
                        outputBuilder.append(sortedProblems.last().number).append("\n");
                    } else {
                        outputBuilder.append(sortedProblems.first().number).append("\n");
                    }
                }
            }
        }
        System.out.print(outputBuilder.toString());
    }
}