import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static class Flower implements Comparable<Flower> {
        int startDay;
        int endDay;

        public Flower(int startDay, int endDay) {
            this.startDay = startDay;
            this.endDay = endDay;
        }

        @Override
        public int compareTo(Flower other) {
            if (this.startDay != other.startDay) {
                return this.startDay - other.startDay;
            }
            return other.endDay - this.endDay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] daysOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        ArrayList<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int startTotalDays = dateToDays(startMonth, startDay, daysOfMonth);
            int endTotalDays = dateToDays(endMonth, endDay, daysOfMonth);

            flowers.add(new Flower(startTotalDays, endTotalDays));
        }

        Collections.sort(flowers);

        int startTargetDay = dateToDays(3, 1, daysOfMonth);
        int endTargetDay = dateToDays(11, 30, daysOfMonth);

        int count = 0;
        int currentEndDay = startTargetDay;
        int maxEndDayInStep = 0;
        int index = 0;

        while (currentEndDay <= endTargetDay) {
            boolean foundNextFlower = false;

            while (index < N && flowers.get(index).startDay <= currentEndDay) {
                maxEndDayInStep = Math.max(maxEndDayInStep, flowers.get(index).endDay);
                foundNextFlower = true;
                index++;
            }
            
            if (foundNextFlower) {
                currentEndDay = maxEndDayInStep;
                count++;
            } else {
                count = 0;
                break;
            }
        }
        
        if (currentEndDay <= endTargetDay) {
            count = 0;
        }

        System.out.println(count);
    }

    public static int dateToDays(int month, int day, int[] daysOfMonth) {
        int totalDays = 0;
        for (int i = 1; i < month; i++) {
            totalDays += daysOfMonth[i];
        }
        totalDays += day;
        return totalDays;
    }
}