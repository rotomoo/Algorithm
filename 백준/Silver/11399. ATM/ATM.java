import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());
        int[] p= new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            p[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(p);
        int sum=0;
        int time=0;
        for (int i=0; i<n; i++) {
            time+=p[i];
            sum+=time;
        }
        System.out.print(sum);
    }
}
