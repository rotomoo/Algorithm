import java.util.*;

public class Main {
    static String S, T;
    static boolean result = false;

    static void dfs(String current) {
        // 도달하면 종료
        if (current.length() == S.length()) {
            if (current.equals(S)) result = true;
            return;
        }

        // 뒤에 A → 제거
        if (current.endsWith("A")) {
            dfs(current.substring(0, current.length() - 1));
        }

        // 앞에 B → 제거 후 뒤집기
        if (current.startsWith("B")) {
            String next = new StringBuilder(current.substring(1)).reverse().toString();
            dfs(next);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLine();
        T = sc.nextLine();

        dfs(T);
        System.out.println(result ? 1 : 0);
    }
}