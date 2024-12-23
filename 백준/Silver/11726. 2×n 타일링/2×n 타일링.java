import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dy = new int[n+1];
        dy[1] = 1;
        if (n==1) {
            System.out.print(1);
            System.exit(0);
        }
        dy[2] = 2;
        for (int i=3; i<=n; i++) {
            dy[i] = (dy[i-2] + dy[i-1]) % 10007;
        }
        System.out.print(dy[n]);
    }
}