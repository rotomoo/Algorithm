class Solution {
    static int[] unf;

    public static int Find(int v) {
        if (v==unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa!=fb) unf[fa] = fb;
    }

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        unf = new int[n+1];
        for (int i = 0; i < wires.length; i++) {
            for (int t = 1; t <= n; t++) unf[t] = t;
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                Union(wires[j][0], wires[j][1]);
            }
            for (int k = 1; k <= n; k++) Find(k);
            int cnt=0;
            for (int l = 2; l <= n; l++) {
                if (unf[l] != unf[1]) {
                    cnt++;
                }
            }
            answer = Math.min(answer, Math.abs(n - 2 * cnt));
        }
        return answer;
    }
}