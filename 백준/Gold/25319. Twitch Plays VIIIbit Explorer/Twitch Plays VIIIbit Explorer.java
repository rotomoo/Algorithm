import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int c;
    static int playerX;
    static int playerY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[] ds = {"U", "R", "D", "L"};
    static char[][] map;
    static StringBuilder playerId;
    static StringBuilder inventory;
    static StringBuilder command;
    static ArrayDeque<Coordinate> answerCoordinates;

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void move(Coordinate coordinate) {
        int dxTotal = coordinate.x - playerX;
        int dyTotal = coordinate.y - playerY;

        if (dxTotal != 0) {
            int directionX = dxTotal > 0 ? 2 : 0; // 2 = "D", 0 = "U"
            int moveCnt = Math.abs(dxTotal);
            command.append(ds[directionX].repeat(moveCnt));
            playerX += dx[directionX] * moveCnt;
        }

        if (dyTotal != 0) {
            int directionY = dyTotal > 0 ? 1 : 3; // 1 = "R", 3 = "L"
            int moveCnt = Math.abs(dyTotal);
            command.append(ds[directionY].repeat(moveCnt));
            playerY += dy[directionY] * moveCnt;
        }
    }

    public static void findAnswer() {
        while (!answerCoordinates.isEmpty()) {

            Coordinate nextCoordinate = answerCoordinates.poll();

            move(nextCoordinate);
            command.append("P");
        }

        // 끝까지 이동
        move(new Coordinate(n, m));
        System.out.println(c + " " + command.length());
        System.out.print(command);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n + 1][m + 1];
        inventory = new StringBuilder();
        command = new StringBuilder();
        playerX = 1;
        playerY = 1;

        // 입력받기 시간복잡도 (n * n = max 125000)
        for (int i = 1; i <= n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 1; j <= charArray.length; j++) {
                map[i][j] = charArray[j - 1];
            }
        }

        playerId = new StringBuilder(br.readLine());
        answerCoordinates = new ArrayDeque<>();

        // 처음 세팅 시간복잡도 ((n * m) * n * m = max 6250000)
        firstSetting();

        findAnswer();
    }

    private static void firstSetting() {
        String playerIdString = playerId.toString();

        // 반례
//        3 4 4
//        aaaa
//        bbbb
//        cccc
//        aaab
//        a= 4 b= 4 c= 4
//        a= 3 b= 1

        // 던전의 각 문자별 최대 개수 계산
        Map<Character, Integer> mapCharCount = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                mapCharCount.put(map[i][j], mapCharCount.getOrDefault(map[i][j], 0) + 1);
            }
        }

        // 플레이어 아이디의 각 문자별 개수 계산
        Map<Character, Integer> playerIdCount = new HashMap<>();
        for (char c : playerIdString.toCharArray()) {
            playerIdCount.put(c, playerIdCount.getOrDefault(c, 0) + 1);
        }

        // 각 문자의 던전 내 최대 개수와 비교하여 강화 가능한 최대 횟수 계산
        c = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : playerIdCount.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();
            if (!mapCharCount.containsKey(key) || mapCharCount.get(key) < count) {
                c = 0;
                break;
            }
            c = Math.min(c, mapCharCount.get(key) / count);
        }


        // 최대로 가능한 만큼 늘리기
        playerId = new StringBuilder(playerIdString.repeat(c));

        int requiredIdx = 0;

        // 2500 * 50 * 50 = 6250000
        for (int i = 0; i < playerId.length(); i++) {
            boolean findYn = false;
            char requiredChar = playerId.charAt(requiredIdx);

            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {

                    // 현재 좌표가 주워야되는 좌표라면
                    if (requiredChar == map[j][k]) {
                        map[j][k] = ' ';
                        findYn = true;
                        // 무작위 좌표 추가
                        answerCoordinates.offer(new Coordinate(j, k));
                        requiredIdx++;
                        break;
                    }
                }
                if (findYn) {
                    break;
                }
            }
        }
    }
}