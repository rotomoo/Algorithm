
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    
    static class Town implements Comparable<Town> {
        int address, hour;

        public Town(int address, int hour) {
            this.address = address;
            this.hour = hour;
        }

        @Override
        public int compareTo(Town town) {
            // 오름차순
            return this.hour - town.hour;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] hours = new int[N + 1];
        ArrayList<ArrayList<Town>> towns = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            towns.add(new ArrayList<>());
        }

        Arrays.fill(hours, Integer.MAX_VALUE);
        hours[1] = 0;

        for (int[] getRoad : road) {
            towns.get(getRoad[0]).add(new Town(getRoad[1], getRoad[2]));
            towns.get(getRoad[1]).add(new Town(getRoad[0], getRoad[2]));
        }

        PriorityQueue<Town> pq = new PriorityQueue<>();
        pq.offer(new Town(1, 0));

        while (!pq.isEmpty()) {
            Town nowTown = pq.poll();

            if (nowTown.hour > hours[nowTown.address]) continue;

            for (Town town : towns.get(nowTown.address)) {
                int takenTime = nowTown.hour + town.hour;
                if (hours[town.address] > takenTime) {
                    hours[town.address] = takenTime;
                    pq.offer(new Town(town.address, takenTime));
                }
            }
        }

        for (int hour: hours) if (K >= hour) answer++;
        return answer;
    }
}