import java.io.*;

public class Main {
    public static int isCheck(int num) {
        int sum = num;
        while (num != 0) {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ch = new int[10001];
        for (int i=1; i<=10000; i++) {
            int n = isCheck(i);
            if (n<=10000) {
                ch[n]=1;
            }
        }

        for (int i=1; i<=10000; i++) {
            if (ch[i]==0) {
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
