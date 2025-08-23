import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sensorCount = Integer.parseInt(br.readLine().trim());
        int stationCount = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sensors = new int[sensorCount];
        for (int i = 0; i < sensorCount; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);

        List<Integer> uniqs = new ArrayList<>();
        uniqs.add(sensors[0]);
        for (int i = 1; i < sensorCount; i++) {
            if (sensors[i] != sensors[i - 1]) {
                uniqs.add(sensors[i]);
            }
        }

        int uniqCount = uniqs.size();
        if (stationCount >= uniqCount) {
            System.out.println(0);
            return;
        }

        int[] gaps = new int[uniqCount - 1];
        for (int i = 0; i < uniqCount - 1; i++) {
            int diff = uniqs.get(i + 1) - uniqs.get(i);
            gaps[i] = diff;
        }

        Arrays.sort(gaps);

        int total = 0;
        for (int g : gaps) {
            total += g;
        }

        for (int i = 0; i < stationCount - 1; i++) {
            total -= gaps[gaps.length - 1 - i];
        }

        System.out.println(total);
    }
}