import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] ch;
    static ArrayList<ArrayList<Integer>> list;

    public int BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        ch[1]=1;
        int L=0;
        while (!q.isEmpty()) {
            L = q.size();
            for (int i=0; i<L; i++) {
                int now = q.poll();
                for (int v : list.get(now)) {
                    if (ch[v]==0) {
                        ch[v]=1;
                        q.offer(v);
                    }
                }
            }
        }
        return L;
    }

    public int solution(int n, int[][] edge) {
        list = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i=0; i<edge.length; i++) {
            list.get(edge[i][0]).add(edge[i][1]);
            list.get(edge[i][1]).add(edge[i][0]);
        }
        ch= new int[edge.length+1];
        return BFS();
    }
}