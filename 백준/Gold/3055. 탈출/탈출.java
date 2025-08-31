import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] forest;
    static Queue<Coordinate> hedgehogQueue = new LinkedList<>();
    static Queue<Coordinate> waterQueue = new LinkedList<>();
    static int[][] timeMap;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Coordinate {
        int x, y, time;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.time = 0;
        }

        Coordinate(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        forest = new char[R][C];
        timeMap = new int[R][C];
        Coordinate destination = null;

        for (int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                forest[i][j] = row.charAt(j);
                timeMap[i][j] = -1;

                if (forest[i][j] == 'S') {
                    hedgehogQueue.add(new Coordinate(i, j, 0));
                    timeMap[i][j] = 0;
                } else if (forest[i][j] == '*') {
                    waterQueue.add(new Coordinate(i, j));
                } else if (forest[i][j] == 'D') {
                    destination = new Coordinate(i, j);
                }
            }
        }

        int result = bfs(destination);

        if (result == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(Coordinate dest) {
        while (!hedgehogQueue.isEmpty()) {

            int waterCount = waterQueue.size();
            for (int i = 0; i < waterCount; i++) {
                Coordinate currentWater = waterQueue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = currentWater.x + dx[d];
                    int ny = currentWater.y + dy[d];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (forest[nx][ny] == '.') {
                            forest[nx][ny] = '*';
                            waterQueue.add(new Coordinate(nx, ny));
                        }
                    }
                }
            }

            int hedgehogCount = hedgehogQueue.size();
            for (int i = 0; i < hedgehogCount; i++) {
                Coordinate currentHedgehog = hedgehogQueue.poll();

                if (currentHedgehog.x == dest.x && currentHedgehog.y == dest.y) {
                    return currentHedgehog.time;
                }

                for (int d = 0; d < 4; d++) {
                    int nx = currentHedgehog.x + dx[d];
                    int ny = currentHedgehog.y + dy[d];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if ((forest[nx][ny] == '.' || forest[nx][ny] == 'D') && timeMap[nx][ny] == -1) {
                            timeMap[nx][ny] = currentHedgehog.time + 1;
                            hedgehogQueue.add(new Coordinate(nx, ny, currentHedgehog.time + 1));
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}