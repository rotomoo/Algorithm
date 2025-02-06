import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String isCheck(int v) {
        int[] ch = new int[v];
        int sum = 1;
        for (int i=2; i<v; i++) {
            if (v%i==0) {
                sum+=i;
                ch[i]=1;
            }
        }
        if (sum==v) {
            String answer = v + " = 1";
            for (int i=2; i<v; i++) {
                if (ch[i]==1) {
                    answer += " + "+ i;
                }
            }
            return answer;
        }
        return v + " is NOT perfect.";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n==-1) break;
            System.out.println(isCheck(n));
        }
    }
}
