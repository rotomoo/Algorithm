import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Point {
        int idx, value;

        public Point(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public int solution(int[] priorities, int location) {

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Point(i, priorities[i]));
        }
        int answer = 1;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            boolean flag = false;
            for (Point x : q) {
                if (x.value > tmp.value) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                q.offer(tmp);
            }
            else {
                if (tmp.idx == location) return answer;
                answer++;
            }
        }
        return answer;
    }
}