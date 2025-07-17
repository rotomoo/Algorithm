import java.util.*;

public class Main {
    static class Coordinate {
        int x, y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static int max = 0;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();

        dfs(board, 0);
        System.out.println(max);
    }

    private static void dfs(int[][] b, int depth) {
        if (depth == 5) {
            for (int[] row : b) {
                for (int val : row) {
                    max = Math.max(max, val);
                }
            }
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] moved = move(b, dir);
            dfs(moved, depth + 1);
        }
    }

    private static Coordinate getPosition(int i, int j, int dir) {
        switch (dir) {
            case 0: return new Coordinate(j, i);             // 상 : 위에서 아래로
            case 1: return new Coordinate(i, N - 1 - j);     // 우 : 오른쪽에서 왼쪽
            case 2: return new Coordinate(N - 1 - j, i);     // 하 : 아래에서 위
            case 3: return new Coordinate(i, j);             // 좌 : 왼쪽에서 오른쪽
        }
        return null;
    }

    private static int[][] move(int[][] b, int dir) {
        int[][] newBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            int idx = (dir == 0 || dir == 3) ? 0 : N - 1;
            boolean merged = false;

            for (int j = 0; j < N; j++) {
                Coordinate pos = getPosition(i, j, dir);
                int value = b[pos.x][pos.y];
                if (value == 0) {
                    continue;
                }

                if (line[idx] == 0) {
                    line[idx] = value;
                    merged = false;
                } else if (line[idx] == value && !merged) {
                    line[idx] *= 2;
                    merged = true;
                } else {
                    idx += (dir == 0 || dir == 3) ? 1 : -1;
                    line[idx] = value;
                    merged = false;
                }
            }

            for (int j = 0; j < N; j++) {
                Coordinate pos = getPosition(i, j, dir);
                newBoard[pos.x][pos.y] = line[j];
            }
        }

        return newBoard;
    }
}