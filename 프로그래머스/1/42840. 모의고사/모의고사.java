import java.util.ArrayList;

class Solution {

    public static int calc(int[] curArr, int[] answers) {
        int cnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == curArr[i % curArr.length]) cnt++;
        }
        return cnt;
    }

    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int firstCnt = 0;
        int secondCnt = 0;
        int thirdCnt = 0;

        for (int i = 0; i < answers.length; i++) {
            firstCnt = calc(first, answers);
            secondCnt = calc(second, answers);
            thirdCnt = calc(third, answers);
        }

        int max = Math.max(firstCnt, Math.max(secondCnt, thirdCnt));
        if (firstCnt == max) answer.add(1);
        if (secondCnt == max) answer.add(2);
        if (thirdCnt == max) answer.add(3);

        return answer.stream().mapToInt(i -> i).toArray();
    }
}