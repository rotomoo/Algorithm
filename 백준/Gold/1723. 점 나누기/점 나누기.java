import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        double[] angles = new double[n];
        for (int i = 0; i < n; i++) {
            angles[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(angles);

        double sectorAngle = 360.0 / k;
        int minDiff = n;

        for (int i = 0; i < n; i++) {
            double startAngle = angles[i];
            int[] counts = new int[k];

            for (int j = 0; j < n; j++) {
                double rotatedAngle = angles[j] - startAngle;
                if (rotatedAngle < 0) {
                    rotatedAngle += 360.0;
                }
                
                int sectorIndex = (int) (rotatedAngle / sectorAngle);
                
                if (sectorIndex < k) {
                    counts[sectorIndex]++;
                }
            }

            int maxCount = 0;
            int minCount = n;
            for (int count : counts) {
                if (count > maxCount) {
                    maxCount = count;
                }
                if (count < minCount) {
                    minCount = count;
                }
            }

            int currentDiff = maxCount - minCount;
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
            }
        }
        
        System.out.println(minDiff);
    }
}