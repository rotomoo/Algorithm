import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> brotherMap = new HashMap<>();
        Set<Integer> chulsooSet = new HashSet<>();
        int count = 0;

        for (int t : topping) {
            brotherMap.put(t, brotherMap.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            chulsooSet.add(t);
            brotherMap.put(t, brotherMap.get(t) - 1);
            if (brotherMap.get(t) == 0) {
                brotherMap.remove(t);
            }

            if (chulsooSet.size() == brotherMap.size()) {
                count++;
            }
        }

        return count;
    }
}