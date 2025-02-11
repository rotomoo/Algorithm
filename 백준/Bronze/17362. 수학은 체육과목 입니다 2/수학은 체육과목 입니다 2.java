import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = {2,1,2,3,4,5,4,3,2};
        System.out.println(arr[Integer.parseInt(br.readLine())%8]);
    }
}
