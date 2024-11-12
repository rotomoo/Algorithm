class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        String[][] map = new String[park.length][park[0].length()];

        int curX = 0;
        int curY = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[1].length; j++) {
                map[i][j] = String.valueOf(park[i].charAt(j));
                if (map[i][j].equals("S")) {
                    curX = i;
                    curY = j;
                }
            }
        }

        int direction = 0;
        for (String route : routes) {
            String[] split = route.split(" ");
            switch (split[0]) {
                case "N" :
                    direction = 0;
                    break;
                case "E" :
                    direction = 1;
                    break;
                case "S" :
                    direction = 2;
                    break;
                case "W" :
                    direction = 3;
                    break;
            }

            int firstX = curX;
            int firstY = curY;
            for (int i = 0; i < Integer.parseInt(split[1]); i++) {
                int nx = curX + dx[direction];
                int ny = curY + dy[direction];
                if (nx >= 0 && nx < park.length && ny >= 0 && ny < park[1].length() && !map[nx][ny].equals("X")) {
                    curX = nx;
                    curY = ny;
                }
                else {
                    curX = firstX;
                    curY = firstY;
                    break;
                }
            }
        }
        return new int[]{curX, curY};
    }
}