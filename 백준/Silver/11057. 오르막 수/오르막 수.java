import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dy = new int[n+1][10];
        dy[0][9]=1;
        for (int i=1; i<=n; i++) {
            for (int j=9; j>=0; j--) {
                dy[i][j] = j==9 ? dy[i-1][j] : dy[i-1][j] + dy[i][j+1];
                dy[i][j] %= 10007;
            }
        }
        System.out.print(Arrays.stream(dy[n]).sum()%10007);
    }
}
