import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] schedule = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> multitap = new HashSet<>();
        int unplugCount = 0;

        for (int i = 0; i < k; i++) {
            int currentAppliance = schedule[i];

            if (multitap.contains(currentAppliance)) {
                continue;
            }

            if (multitap.size() < n) {
                multitap.add(currentAppliance);
                continue;
            }

            int itemToUnplug = -1;
            int latestUseIndex = -1;

            for (int pluggedItem : multitap) {
                int nextUseIndex = Integer.MAX_VALUE;
                for (int j = i + 1; j < k; j++) {
                    if (schedule[j] == pluggedItem) {
                        nextUseIndex = j;
                        break;
                    }
                }

                if (nextUseIndex == Integer.MAX_VALUE) {
                    itemToUnplug = pluggedItem;
                    break;
                }
                
                if (nextUseIndex > latestUseIndex) {
                    latestUseIndex = nextUseIndex;
                    itemToUnplug = pluggedItem;
                }
            }

            multitap.remove(itemToUnplug);
            multitap.add(currentAppliance);
            unplugCount++;
        }

        System.out.println(unplugCount);
    }
}