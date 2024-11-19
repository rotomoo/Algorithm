import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer=0;
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        while (true) {
            if (idx == truck_weights.length) {
                answer += bridge_length;
                break;
            }
            if (q.size() == bridge_length) {
                weight += q.poll();
            }
            if (truck_weights[idx] <= weight) {
                weight -= truck_weights[idx];
                q.offer(truck_weights[idx++]);
            }
            else q.offer(0);
            answer++;
        }
        return answer;
    }
}