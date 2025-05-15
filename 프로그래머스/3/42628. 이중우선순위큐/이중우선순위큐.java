import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pqReverse = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation: operations) {
            String[] operationSplit = operation.split(" ");
            String oper = operationSplit[0];
            int number = Integer.parseInt(operationSplit[1]);
            if (oper.equals("I")) {
                pq.offer(number);
                pqReverse.offer(number);
            }
            else {
                if (number == 1) {
                    if (!pq.isEmpty() && !pqReverse.isEmpty()) {
                        int targetNumber = pqReverse.poll();
                        pq.remove(targetNumber);
                    }
                }
                else {
                    if (!pq.isEmpty() && !pqReverse.isEmpty()) {
                        int targetNumber = pq.poll();
                        pqReverse.remove(targetNumber);
                    }
                }
            }
        }
        
        if (!pq.isEmpty() && !pqReverse.isEmpty()) {
            answer[0] = pqReverse.poll();
            answer[1] = pq.poll();
        }
        
        return answer;
    }
}