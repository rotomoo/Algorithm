import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int toNodeId;
        int cost;
        
        public Node(int toNodeId, int cost) {
            this.toNodeId = toNodeId;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        List<List<Node>> relation = new ArrayList<>();
        for (int i=0; i<n; i++) {
            relation.add(new ArrayList<>());
        }
        
        for (int i=0; i<costs.length; i++) {
            relation.get(costs[i][0]).add(new Node(costs[i][1], costs[i][2]));
            relation.get(costs[i][1]).add(new Node(costs[i][0], costs[i][2]));
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0,0));
            
        int connectCnt = 0;
        
        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            
            if (visited[nowNode.toNodeId]) {
                continue;
            }
            visited[nowNode.toNodeId] = true;
            answer += nowNode.cost;
            
            if (connectCnt == n) {
                break;
            }
            
            for (Node nextNode : relation.get(nowNode.toNodeId)) {
                if (!visited[nextNode.toNodeId]) {
                    pq.offer(nextNode);
                }
            }
        }
        
        return answer;
    }
}