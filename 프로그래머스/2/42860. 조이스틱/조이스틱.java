import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point {
        String tmp;
        int cur, cnt;

        public Point(String tmp, int cur, int cnt) {
            this.tmp = tmp;
            this.cur = cur;
            this.cnt = cnt;
        }
    }
    static String Name;

    public static int upDown(char v) {
        int cnt = Math.min(v - 'A', 'Z' - v + 1);
        return cnt;
    }

    public static int BFS (String tmp, int cur, int cnt) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(tmp, 0,0));
        int[] dx = {1, -1};
        while (!q.isEmpty()) {
            Point poll = q.poll();
            if (poll.tmp.charAt(poll.cur) != Name.charAt(poll.cur)) poll.cnt += upDown(Name.charAt(poll.cur));
            char[] chars = poll.tmp.toCharArray();
            chars[poll.cur] = Name.charAt(poll.cur);
            for (int j = 0; j < 2; j++) {
                int nx = poll.cur + dx[j];
                if (nx==-1) nx = Name.length()-1;
                else if (nx==Name.length()) nx = 0;
                if (new String(chars).equals(Name)) return poll.cnt;
                q.offer(new Point(new String(chars), nx, poll.cnt + 1));
            }
        }
        return 0;
    }

    public static int solution(String name) {
        String tmp = "A".repeat(name.length());
        Name = name;
        return BFS(tmp, 0, 0);
    }
}