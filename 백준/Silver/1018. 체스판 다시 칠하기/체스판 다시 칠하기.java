import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] graph = new char[n][m];
        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                graph[i][j]=str.charAt(j);
            }
        }
        int answer=Integer.MAX_VALUE;
        for (int i=0; i<n-7; i++) {
            for (int j=0; j<m-7; j++) {
                char tmp = graph[i][j];
                int cnt =0;
                for (int k=i; k<i+8; k++) {
                    for (int l=j; l<j+8; l++) {
                        if (graph[k][l]!=tmp) cnt++;
                        if (tmp=='W') tmp='B';
                        else tmp='W';
                    }
                    if (tmp=='W') tmp='B';
                    else tmp='W';
                }
                cnt=Math.min(cnt,64-cnt);
                answer=Math.min(answer,cnt);
            }
        }
        System.out.print(answer);
    }
}