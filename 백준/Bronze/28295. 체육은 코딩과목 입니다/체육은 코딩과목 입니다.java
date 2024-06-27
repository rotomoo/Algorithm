import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] direction = {"N", "E", "S", "W"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int directionIdx = 0;
        for (int i = 0; i < 10; i++) {
            directionIdx += Integer.parseInt(br.readLine());
        }

        directionIdx %= 4;
        System.out.println(direction[directionIdx]);
    }

}
