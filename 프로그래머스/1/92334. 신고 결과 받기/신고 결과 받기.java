import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> result = new LinkedHashMap<>();

        for (String x : id_list) {
            result.put(x, 0);
            reportMap.put(x, new HashSet<>());
        }

        for (String x : report) {
            String[] tmp = x.split(" ");
            reportMap.get(tmp[1]).add(tmp[0]);
        }

        for (String key : reportMap.keySet()) {
            if (reportMap.get(key).size() >= k) {
                HashSet<String> reporters = reportMap.get(key);
                for (String reporter : reporters) {
                    result.put(reporter, result.get(reporter) + 1);
                }
            }
        }
        return result.values().stream().mapToInt(i -> i).toArray();
    }
}