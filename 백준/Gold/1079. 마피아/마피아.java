import java.io.*;
import java.util.*;

public class Main {
    static class Player {
        int id;
        int guilt;
        boolean alive = true;

        public Player(int id, int guilt) {
            this.id = id;
            this.guilt = guilt;
        }
    }

    private static int N;
    private static List<Player> players;
    private static int[][] R;
    private static int mafiaId;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        players = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int guilt = Integer.parseInt(st.nextToken());
            players.add(new Player(i, guilt));
        }

        R = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                R[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mafiaId = Integer.parseInt(br.readLine().trim());

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int nightCnt) {
        if (isOnlyMafiaAlive()) {
            answer = Math.max(answer, nightCnt);
            return;
        }

        int aliveCnt = countAlive();

        if (aliveCnt % 2 == 1) { // 낮
            Player lynch = pickLynch();
            if (lynch.id == mafiaId) {
                answer = Math.max(answer, nightCnt);
                return;
            }
            lynch.alive = false;
            dfs(nightCnt);
            lynch.alive = true;
        } else { // 밤
            for (Player target : players) {
                if (!target.alive || target.id == mafiaId) continue;

                target.alive = false;
                applyEffect(target, true);

                dfs(nightCnt + 1);

                applyEffect(target, false);
                target.alive = true;
            }
        }
    }

    private static boolean isOnlyMafiaAlive() {
        for (Player p : players) {
            if (p.id == mafiaId) continue;
            if (p.alive) return false;
        }
        return getPlayer(mafiaId).alive;
    }

    private static int countAlive() {
        int cnt = 0;
        for (Player p : players) {
            if (p.alive) cnt++;
        }
        return cnt;
    }

    private static Player pickLynch() {
        Player choice = null;
        for (Player p : players) {
            if (!p.alive) continue;
            if (choice == null || p.guilt > choice.guilt || (p.guilt == choice.guilt && p.id < choice.id)) {
                choice = p;
            }
        }
        return choice;
    }

    private static void applyEffect(Player dead, boolean apply) {
        for (Player p : players) {
            if (p.alive) {
                p.guilt += apply ? R[dead.id][p.id] : -R[dead.id][p.id];
            }
        }
    }

    private static Player getPlayer(int id) {
        for (Player p : players) {
            if (p.id == id) return p;
        }
        return null;
    }
}
