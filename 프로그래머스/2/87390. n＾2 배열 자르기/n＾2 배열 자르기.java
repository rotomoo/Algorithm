import java.util.ArrayList;

class Solution {
    public ArrayList<Long> solution(int n, long left, long right) {
        ArrayList<Long> answer = new ArrayList<>();
        for (long i = left; i < right+ 1; i++) {
            answer.add(Math.max(i / n, i % n) + 1);
        }
        return answer;
    }
}