import java.util.*;

public class Main {
    static int N;
    static List<String> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            N = sc.nextInt();
            result = new ArrayList<>();
            dfs(1, "1");
            Collections.sort(result);
            for (String s : result) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    private static void dfs(int num, String expr) {
        if (num == N) {
            if (evaluate(expr) == 0) {
                result.add(expr);
            }
            return;
        }

        int next = num + 1;
        dfs(next, expr + " " + next); // 공백 = 이어붙이기
        dfs(next, expr + "+" + next); 
        dfs(next, expr + "-" + next); 
    }

    private static int evaluate(String expr) {
        String s = expr.replace(" ", "");
        StringTokenizer st = new StringTokenizer(s, "+-", true);

        int sum = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (op.equals("+")) {
                sum += num;
            } else {
                sum -= num;
            }
        }

        return sum;
    }
}