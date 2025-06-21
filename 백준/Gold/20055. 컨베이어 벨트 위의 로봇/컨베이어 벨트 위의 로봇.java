import java.util.*;

public class Main {
    static int n, k;
    static int[] belt;
    static boolean[] robotYns;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        belt = new int[2 * n];
        robotYns = new boolean[n];

        for (int i = 0; i < 2 * n; i++) {
            belt[i] = sc.nextInt();
        }

        int answer = 0;
        while (k > 0) {
            answer++;
            rotate();
            moveRobots();
            loadRobot();
        }

        System.out.println(answer);
    }

    // 회전
    private static void rotate() {
        int last = belt[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = last;

        for (int i = n - 1; i > 0; i--) {
            robotYns[i] = robotYns[i - 1];
        }
        // 회전 후 로봇도 이동
        robotYns[0] = false;
        
        // 로봇이 내리는 위치에 도달하면 그 즉시 내린다
        robotYns[n - 1] = false;
    }

    // 현재 칸에 로봇이 없고 앞에 로봇이 있으며 내구도 > 0이면 로봇 이동
    private static void moveRobots() {
        for (int i = n - 1; i > 0; i--) {
            if (!robotYns[i] && robotYns[i - 1] && belt[i] > 0) {
                robotYns[i] = true;
                robotYns[i - 1] = false;
                belt[i]--;
                if (belt[i] == 0) k--;
            }
        }
        
        // 로봇이 내리는 위치에 도달하면 그 즉시 내린다
        robotYns[n - 1] = false;
    }

    // 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
    private static void loadRobot() {
        if (belt[0] > 0) {
            robotYns[0] = true;
            belt[0]--;
            if (belt[0] == 0) k--;
        }
    }
}