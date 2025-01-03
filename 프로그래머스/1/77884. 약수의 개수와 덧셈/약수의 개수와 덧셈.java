class Solution {

    public static int calc(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) cnt++;
        }
        if (cnt % 2 == 1) {
            num = -num;
        }
        return num;
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int idx = left; idx <= right; idx++) {
            answer += calc(idx);
        }
        return answer;
    }
}