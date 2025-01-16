import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[] answer,ch;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void DFS(int L,int s) throws IOException {
        if (L==m){
            for (int x : answer) bw.write(x+" ");
            bw.newLine();
        }
        else {
            for (int i=s; i<=n; i++) {
                answer[L]=i;
                DFS(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ch=new int[n+1];
        answer=new int[m];
        DFS(0,1);
        bw.flush();
        bw.close();
    }
}
