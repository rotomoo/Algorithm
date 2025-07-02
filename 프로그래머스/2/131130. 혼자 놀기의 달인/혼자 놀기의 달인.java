import java.util.*;

class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        List<Integer> groupSizes = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) continue;

            int count = 0;
            int current = i;

            while (!visited[current]) {
                visited[current] = true;
                current = cards[current] - 1;
                count++;
            }

            groupSizes.add(count);
        }

        if (groupSizes.size() < 2) return 0;

        groupSizes.sort(Collections.reverseOrder());

        return groupSizes.get(0) * groupSizes.get(1);
    }
}