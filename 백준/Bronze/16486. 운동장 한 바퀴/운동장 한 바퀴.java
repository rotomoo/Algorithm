import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double answer = Double.parseDouble(br.readLine())*2;
        answer += Double.parseDouble(br.readLine())*2*3.141592;
        System.out.println(String.format("%.6f",answer));
    }
}
