import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, answer;
    static int[] arr;

    public static boolean check(int v) {
        for (int i=0; i<v; i++) {
            if (arr[v]==arr[i]) return false;
            else if (Math.abs(v-i)==Math.abs(arr[v]-arr[i])) return false;
        }
        return true;
    }
    public static void DFS(int L) {
        if (L==n) {
            answer++;
            return;
        }
        else {
            for (int i=0; i<n; i++) {
                arr[L]=i;
                if (check(L)) DFS(L+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr= new int[n];
        DFS(0);
        System.out.print(answer);
    }
}
