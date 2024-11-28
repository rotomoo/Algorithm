import java.util.Arrays;


class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, ((o1, o2) -> o1[1] - o2[1]));

        int answer = 1;
        int idx = 0;
        int endX = targets[0][1];

        for (int[] target : targets) {
            idx++;
            int startX = target[0];
            if (endX > startX) continue;
            endX = target[1];
            answer++;
        }

        return answer;
    }
}