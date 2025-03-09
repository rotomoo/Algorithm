import java.util.Arrays;

class Solution {
    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long lt = times[0];
        long rt = times[times.length - 1] * (long)n;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long cnt = 0;
            for (int time : times) {
                cnt += mid / (long) time;
            }
            if (cnt >= n) {
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
        }

        return answer;
    }
}