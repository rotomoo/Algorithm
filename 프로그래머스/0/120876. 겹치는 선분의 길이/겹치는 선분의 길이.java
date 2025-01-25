import java.util.*;

class Solution {
    
    static class Line implements Comparable<Line>{
        private int dotX;
        private int dotY;

        public Line(int dotX, int dotY) {
            this.dotX = dotX;
            this.dotY = dotY;
        }

        @Override
        public int compareTo(Line o) {
            return this.dotX - o.dotX;
        }

        @Override
        public boolean equals(Object object) {
            Line o = (Line) object;
            if(this.dotX == o.dotX && this.dotY == o.dotY) return true;
            return false;
        }
    }

    public int solution(int[][] lines) {

        List<Line> lineList = new ArrayList<>();

        for (int[] line : lines) {
            lineList.add(new Line(line[0], line[1]));
        }

        Collections.sort(lineList);

        List<Line> twoLines = new ArrayList<>();

        for (int i = 0; i < lineList.size(); i++) {
            for (int j = i + 1; j < lineList.size(); j++) {
                int firstDotY = lineList.get(i).dotY;
                int secondDotX = lineList.get(j).dotX;
                int secondDotY = lineList.get(j).dotY;

                if (firstDotY > secondDotX) {
                    for (int k = secondDotX; k < Math.min(firstDotY, secondDotY); k++) {
                        Line line = new Line(k, k + 1);
                        if (!twoLines.contains(line)){
                            twoLines.add(line);
                        }
                    }
                }
            }
        }

        return twoLines.size();
    }
}