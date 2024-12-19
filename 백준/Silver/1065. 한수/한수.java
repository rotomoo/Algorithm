import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tmp=0, answer=99;
        int[] arr = new int[3];
        if (n<100) System.out.print(n);
        else if (n<111) System.out.print(99);
        else if (n==1000) System.out.print(144);
        else {
            for (int i=111; i<=n; i++) {
                tmp=i;
                for (int j=2; j>=0; j--) {
                    arr[j]=tmp%10;
                    tmp/=10;
                }
                if (arr[2]-arr[1]==arr[1]-arr[0]) answer++;
            }
            System.out.print(answer);
        }
    }
}
