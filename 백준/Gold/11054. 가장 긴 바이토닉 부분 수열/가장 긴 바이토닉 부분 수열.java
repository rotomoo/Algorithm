import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] dy= new int[n];
        int[] dy2= new int[n];
        dy[0]=1;
        dy2[n-1]=1;
        for (int i=1; i<n; i++) {
            dy[i]=1;
            for (int j=0; j<i; j++) {
                if (arr[i]>arr[j]) {
                    dy[i]=Math.max(dy[i],dy[j]+1);
                }
            }
        }
        for (int i=n-2; i>=0; i--) {
            dy2[i]=1;
            for (int j=n-1; j>i; j--) {
                if (arr[i]>arr[j]) {
                    dy2[i]=Math.max(dy2[i],dy2[j]+1);
                }
            }
        }
        int answer=1;
        for (int i=0; i<n; i++) {
            answer=Math.max(answer,dy[i]+dy2[i]-1);
        }
        System.out.print(answer);
    }
}
