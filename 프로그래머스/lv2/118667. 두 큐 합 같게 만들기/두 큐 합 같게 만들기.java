import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Integer> firstQueue1 = new ArrayDeque<>(List.of(Arrays.stream(queue1).boxed().toArray(Integer[]::new)));
        Queue<Integer> firstQueue2 = new ArrayDeque<>(List.of(Arrays.stream(queue2).boxed().toArray(Integer[]::new)));
        
        long queue1Sum = firstQueue1.stream().mapToLong(i -> i).sum();
        long queue2Sum = firstQueue2.stream().mapToLong(i -> i).sum();
        
        int answer = 0;
        
        while (queue1Sum != queue2Sum) {
            answer++;
            
            if(answer > (queue1.length + queue2.length) * 2) return -1;
            
            if (queue1Sum > queue2Sum) {
                int poll = popAndInsert(firstQueue1, firstQueue2);
                queue1Sum -= poll;
                queue2Sum += poll;
            }
            else {
                int poll = popAndInsert(firstQueue2, firstQueue1);
                queue2Sum -= poll;
                queue1Sum += poll;
            }            
        }

        return answer;
    }

    public int popAndInsert(Queue<Integer> popQueue, Queue<Integer> insertQueue) {
        int poll = popQueue.poll();
        insertQueue.offer(poll);
        return poll;
    }
}