import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();
        String str2= br.readLine();
        int[][] dy = new int[str.length()+1][str2.length()+1];
        for (int i=1; i<=str.length(); i++) {
            for (int j=1; j<=str2.length(); j++) {
                if (str.charAt(i-1)==str2.charAt(j-1)) {
                    dy[i][j]=dy[i-1][j-1]+1;
                }
                else dy[i][j]=Math.max(dy[i-1][j],dy[i][j-1]);
            }
        }
        System.out.print(dy[str.length()][str2.length()]);
    }
}
