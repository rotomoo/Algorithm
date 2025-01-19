import java.util.*;


class Solution {

    static class Line {
        private int x1;
        private int x2;
        private int y1;
        private int y2;
        private int dotIdx1;
        private int dotIdx2;

        public Line(int x1, int x2, int y1, int y2, int dotIdx1, int dotIdx2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.dotIdx1 = dotIdx1;
            this.dotIdx2 = dotIdx2;
        }

        public int getXSlope() {
            return x2 - x1;
        }

        public int getYSlope() {
            return y2 - y1;
        }

        public double getSlope() {
            int ySlope = getYSlope();
            int xSlope = getXSlope();
            return (double) ySlope / (double) xSlope;
        }

        public int getDotIdx1() {
            return dotIdx1;
        }

        public int getDotIdx2() {
            return dotIdx2;
        }
    }
    public static int solution(int[][] dots) {

        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                lines.add(new Line(dots[i][0], dots[j][0], dots[i][1], dots[j][1], i, j));
            }
        }

        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                if (lines.get(i).getSlope() == lines.get(j).getSlope()) {
                    int dotIdx1 = lines.get(i).getDotIdx1();
                    int dotIdx2 = lines.get(i).getDotIdx2();
                    int dotIdx3 = lines.get(j).getDotIdx1();
                    int dotIdx4 = lines.get(j).getDotIdx2();
                    if (dotIdx1 == dotIdx3 || dotIdx1 == dotIdx4) continue;
                    if (dotIdx2 == dotIdx3 || dotIdx2 == dotIdx4) continue;
                    return 1;
                }
            }
        }
        return 0;
    }
}