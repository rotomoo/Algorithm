import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> sub = new ArrayDeque<>();
        int boxNum = 1;
        int answer = 0;

        for (int target : order) {
            while (boxNum <= order.length && (sub.isEmpty() || sub.peekLast() != target)) {
                sub.offerLast(boxNum++);
            }

            if (!sub.isEmpty() && sub.peekLast() == target) {
                sub.pollLast();
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}