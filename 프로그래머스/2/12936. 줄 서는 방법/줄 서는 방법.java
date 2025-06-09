import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> ary = new ArrayList<>();

        // 1부터 n까지 숫자 리스트에 추가하고, 전체 경우의 수 n! 계산
        long total = 1;
        for (int i = 1; i <= n; i++) {
            ary.add(i);
            total *= i;
        }

        // k는 0-based 인덱스로 처리
        k--;

        int idx = 0;
        while (idx < n) {
            // 현재 자리에 고를 수 있는 한 숫자당 경우의 수
            total /= (n - idx);

            // 현재 자리에서 k번째 순열이 포함된 블록의 인덱스를 구함
            int selectIndex = (int)(k / total);

            // 해당 블록의 숫자를 정답에 추가하고 리스트에서 제거
            answer[idx++] = ary.remove(selectIndex);

            // 다음 자리 계산을 위해 k 갱신
            k %= total;
        }

        return answer;
    }
}