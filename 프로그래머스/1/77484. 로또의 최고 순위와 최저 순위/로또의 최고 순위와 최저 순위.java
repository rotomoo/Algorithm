import java.util.HashMap;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        int baseCnt = 0;
        for (int lotto : lottos) {
            if (lotto == 0) zeroCnt++;
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    baseCnt++;
                    continue;
                }
            }
        }

        int[] answer = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            map.put(6 - i, i + 1);
        }
        map.put(0, 6);

        answer[0] = map.get(baseCnt + zeroCnt);
        answer[1] = map.get(baseCnt);

        return answer;
    }
}
