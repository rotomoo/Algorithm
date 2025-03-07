class Solution {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static String dirsTmp;
    static int answer;
    static int[][][][] ch;

    public static void move(int L,int cx, int cy, int x, int y) {
        x = x == -1 ? 0 : x;
        x = x == 11 ? 10 : x;
        y = y == -1 ? 0 : y;
        y = y == 11 ? 10 : y;
        if (cx==x && cy==y) ch[cx][cy][x][y]=1;
        if (ch[cx][cy][x][y]==0) {
            answer++;
            ch[cx][cy][x][y]=1;
            ch[x][y][cx][cy]=1;
        }
        if (L==dirsTmp.length()) return;
        switch (dirsTmp.charAt(L)) {
            case 'U':
                move(L+1, x, y, x, y+1);
                break;
            case 'D':
                move(L+1, x, y, x, y-1);
                break;
            case 'L':
                move(L+1, x, y, x-1, y);
                break;
            case 'R':
                move(L+1, x, y, x+1, y);
                break;
        }
    }

    public int solution(String dirs) {
        answer = 0;
        dirsTmp = dirs;
        ch = new int[11][11][11][11];
        move(0,5,5,5, 5);
        return answer;
    }
}