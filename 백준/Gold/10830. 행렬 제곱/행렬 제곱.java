import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] tmp = new int[a.length][b[0].length];
        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    for (int k = 0; k < a[0].length; k++) {
                        tmp[i][j] += a[i][k] * b[k][j];
                        tmp[i][j] %= 1000;
                    }
                }
            }
        }
        return tmp;
    }

    public static int[][] pow(long L) {
        if (L==1) return graph;
        int[][] ret = pow(L / 2);
        ret = multiply(ret, ret);
        if (L%2 == 1) {
            ret = multiply(ret, graph);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] answer = pow(b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
