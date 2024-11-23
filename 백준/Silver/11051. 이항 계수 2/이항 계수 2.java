import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] arr;
    static long tmp=10007;
    public static long DFS(int n, int k) {
        if (arr[n][k]>0) return arr[n][k];
        if (n==k || k==0) return arr[n][k]=1;
        else return arr[n][k]=(DFS(n-1,k-1)+DFS(n-1,k))%tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new long[n+1][k+1];
        System.out.println(DFS(n,k));
    }
}
