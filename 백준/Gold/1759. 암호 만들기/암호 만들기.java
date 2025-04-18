import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int l,c;
    static char[] answer, arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static boolean isCheck(char[] answer) {
        int cnt=0;
        boolean flag=false;
        for (int x : answer) {
            if (x=='a' || x=='e' || x=='i' || x=='o' || x=='u') {
                flag=true;
            }
            else {
                cnt++;
            }
        }
        if (cnt>1 && flag) return true;
        return false;
    }

    public static void dfs(int L, int s) throws IOException {
        if (L==l) {
            if (isCheck(answer)) {
                for (char x : answer) bw.write(x);
                bw.newLine();
            }
        }
        else {
            for (int i=s; i<c; i++) {
                answer[L]=arr[i];
                dfs(L+1,i+1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        answer=new char[l];
        arr= new char[c];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<c; i++) {
            arr[i]=st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0,0);
        bw.flush();
        bw.close();
    }
}
