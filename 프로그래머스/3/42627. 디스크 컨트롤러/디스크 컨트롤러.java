import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static class Point implements Comparable<Point> {
        int startTime, workTime;

        public Point(int startTime, int workTime) {
            this.startTime = startTime;
            this.workTime = workTime;
        }

        public int compareTo(Point o) {
            if (o.workTime == this.workTime) return this.startTime - o.startTime;
            else return this.workTime - o.workTime;
        }
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Point> pq = new PriorityQueue<>();

        int nowTime = 0;
        int sumTime = 0;
        int idx = 0;
        int count = 0;
        while (count != jobs.length) {
            while (idx < jobs.length && nowTime >= jobs[idx][0]) {
                pq.offer(new Point(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            if (pq.isEmpty()) {
                nowTime = jobs[idx][0];
                continue;
            }
            if (nowTime >= pq.peek().startTime) {
                Point curWork = pq.poll();
                nowTime += curWork.workTime;
                sumTime += nowTime - curWork.startTime;
                count++;
            }
        }
        return sumTime / jobs.length;
    }
}