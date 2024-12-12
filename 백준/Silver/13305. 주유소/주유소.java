import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr= new long[n-1];
        long[] arr2= new long[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i=0; i<n-1; i++) {
            arr[i]=Long.parseLong(st.nextToken());
        }
        long min=Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr2[i]=Long.parseLong(st.nextToken());
            min=Math.min(min,arr2[i]);
            arr2[i]=min;
        }
        long answer=0;
        for (int i=0; i<n-1; i++) {
            answer+=arr[i]*arr2[i];
        }
        System.out.println(answer);
    }
}
