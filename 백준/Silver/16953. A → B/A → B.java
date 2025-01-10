import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long a, b, answer=Integer.MAX_VALUE;
    public static void DFS(int L, Long sum) {
        if (L>answer) return;
        if (sum>b) return;
        if (sum==b) answer=Math.min(answer,L+1);
        else {
            String tmp = sum+"1";
            DFS(L+1,2*sum);
            DFS(L+1,Long.parseLong(tmp));
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        DFS(0,a);
        if (answer==Integer.MAX_VALUE) System.out.print(-1);
        else System.out.println(answer);
    }
}
