public class Solution {

    public static int DFS(int L) {
        if (L==1 || L==2) return 1;
        if (L%2==1) return DFS((L - 1) / 2) + 1;
        else if (L%2==0) return DFS(L / 2);
        return 0;
    }

    public int solution(int n) {
        return DFS(n);
    }
}