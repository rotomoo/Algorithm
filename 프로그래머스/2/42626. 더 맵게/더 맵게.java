import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
         PriorityQueue<Integer> pqScov = new PriorityQueue<>();
         for (int s: scoville) {
             pqScov.add(s);
         }

         int cnt = 0;
         while (pqScov.size() > 1 && pqScov.peek() < K) {
             pqScov.add(pqScov.remove() + pqScov.remove() * 2);
             cnt++;
         }

         return pqScov.peek() >= K ? cnt : -1;
    }
}