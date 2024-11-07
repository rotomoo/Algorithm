import java.io.*;

public class Main {
    static int[] arr;
    public static int DFS(int n) {
        if (arr[n]>0) return arr[n];
        if (n==0) return arr[0]=0;
        else if (n==1) return arr[1]=1;
        else return arr[n]=DFS(n-1)+DFS(n-2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(br.readLine());
        arr = new int[41];
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n==0) bw.write(1+" "+0+"\n");
            else {
                DFS(n);
                bw.write(arr[n-1]+" "+arr[n]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
