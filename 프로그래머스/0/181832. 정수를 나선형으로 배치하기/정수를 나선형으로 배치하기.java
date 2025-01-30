class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int value = 1;
        int x = 0;
        int y = 0;
        int direction = 0;

        while (true) {
            answer[x][y] = value;
            if (value == n*n) break;

            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
                direction = (direction + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
            value++;
        }
        
        return answer;
    }
}