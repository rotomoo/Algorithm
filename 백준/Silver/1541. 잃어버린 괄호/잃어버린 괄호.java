import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strarr = br.readLine().split("-");
        int answer = 0;
        answer = SUM(strarr[0]);
        for (int i=1; i<strarr.length; i++) answer-=SUM(strarr[i]);
        System.out.print(answer);
    }

    public static int SUM(String str) {
        String[] strarr2 = str.split("\\+");
        int tmp=0;
        for (String x : strarr2) tmp+=Integer.parseInt(x);
        return tmp;
    }
}
