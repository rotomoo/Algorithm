import java.util.*;

class Solution {

    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String time : timetable) {
            pq.add(toMinutes(time));
        }

        int busTime = 540;
        int lastCrewTime = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (!pq.isEmpty() && pq.peek() <= busTime && cnt < m) {
                lastCrewTime = pq.poll();
                cnt++;
            }

            if (i == n - 1) {
                if (cnt < m) {
                    return toTimeString(busTime);
                } else {
                    return toTimeString(lastCrewTime - 1);
                }
            }

            busTime += t;
        }

        return "";
    }
    
    private int toMinutes(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }

    private String toTimeString(int minutes) {
        int hour = minutes / 60;
        int minute = minutes % 60;
        return String.format("%02d:%02d", hour, minute);
    }
}