import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wants = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }

        Map<String, Integer> discounts = new HashMap<>();
        Deque<String> windowQueue = new ArrayDeque<>();

        int answer = 0;

        for (int i = 0; i < discount.length; i++) {
            String product = discount[i];
            windowQueue.offer(product);
            discounts.put(product, discounts.getOrDefault(product, 0) + 1);

            if (windowQueue.size() > 10) {
                String removed = windowQueue.poll();
                discounts.put(removed, discounts.get(removed) - 1);
                if (discounts.get(removed) == 0) {
                    discounts.remove(removed);
                }
            }

            if (windowQueue.size() == 10 && matches(wants, discounts)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean matches(Map<String, Integer> wants, Map<String, Integer> discounts) {
        for (String wantKey : wants.keySet()) {
            if (discounts.getOrDefault(wantKey, 0) < wants.get(wantKey)) {
                return false;
            }
        }
        return true;
    }
}