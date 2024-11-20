import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static int[][] lineTmp;
    static int[] combi;
    static ArrayList<Point> result = new ArrayList<>();
    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            Point point = (Point) object;
            if (point.x == this.x && point.y==this.y) {
                return true;
            }
            return false;
        }
    }

    public static StringBuilder[] DrawStar() {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            Point point = result.get(i);
            maxX = Math.max(maxX, point.x);
            maxY = Math.max(maxY, point.y);
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
        }

        long row = maxX-minX+1;
        long col = maxY-minY+1;
        StringBuilder[] answer = new StringBuilder[(int)col];
//        String[] answer = new String[(int) col];
        String tmp = ".".repeat((int)row);
//        Arrays.fill(answer, tmp);
        for (int i = 0; i < col; i++) {
            answer[i] = new StringBuilder(tmp);
        }
        for (Point p : result) {
            long ny = maxY - p.y;
            long nx = p.x - minX;
//            System.out.println(p.x+" "+p.y+" "+nx+" "+ny);
            answer[(int)ny].setCharAt((int)nx,'*');
        }
//        for (Point p : result) {
//            answer[(int)(maxY-minY-p.y)].setCharAt((int)p.x, '*');
//        }
        return answer;
    }

    public static void makeStar(int[] line1, int[] line2) {
        long xDown = (long)line1[0] * (long)line2[1] - (long)line1[1] * (long)line2[0];
        if (xDown==0) return;
        long xUp = (long)line1[1] * (long)line2[2] - (long)line1[2] * (long)line2[1];
        long yUp = (long)line1[2] * (long)line2[0] - (long)line1[0] * (long)line2[2];
        if (xUp % xDown!=0 || yUp % xDown!=0) return;
        long xCheck = xUp / xDown;
        long yCheck = yUp / xDown;
        Point point = new Point(xCheck, yCheck);
        if (result.contains(point)) return;
        result.add(point);
    }

    public static void DFS(int L, int s) {
        if (L==2) {
            makeStar(lineTmp[combi[0]], lineTmp[combi[1]]);
        }
        else {
            for (int i = s; i < lineTmp.length; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public StringBuilder[] solution(int[][] line) {
        lineTmp = line;
        combi = new int[2];
        DFS(0, 0);
        return DrawStar();
    }
}