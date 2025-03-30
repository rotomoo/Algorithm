import java.util.*;
import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dy = new int[k+1];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dy[0]=1;
        for (int i=0; i<n; i++) {
            for (int j=arr[i]; j<=k; j++) {
                dy[j] += dy[j-arr[i]];
            }
        }
        System.out.println(dy[k]);
    }
}