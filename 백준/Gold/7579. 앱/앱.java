import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] marr=new int[n];
        int[] carr=new int[n];
        int jindex=0;
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            marr[i]=Integer.parseInt(st.nextToken());
            carr[i]=Integer.parseInt(st2.nextToken());
            jindex+=carr[i];
        }
        int[] dy=new int[jindex+1];
        for (int i=0; i<n; i++) {
            for (int j=jindex; j>=carr[i]; j--) {
                dy[j]=Math.max(dy[j],dy[j-carr[i]]+marr[i]);
            }
        }
        for (int i=0; i<=jindex; i++) {
            if (dy[i]>=m) {
                System.out.println(i);
                System.exit(0);
            }
        }
    }
}
