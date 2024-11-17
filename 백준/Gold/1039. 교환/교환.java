import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int num,cnt;
        Point(int num, int cnt) {
            this.num=num;
            this.cnt=cnt;
        }
    }
    static int n,k,answer=-1;

    public static void BFS() {
        Queue<Point> q =new LinkedList<>();
        int[][] ch = new int[1000001][k+1];
        q.add(new Point(n,0));
        ch[n][0]=1;
        while (!q.isEmpty()) {
            Point o = q.poll();
            if (o.cnt==k) {
                answer=Math.max(answer,o.num);
                continue;
            }
            int len=String.valueOf(o.num).length();
            for (int i=0; i<len-1; i++) {
                for (int j=i+1; j<len; j++) {
                    int tmp= swap(o.num,i,j);
                    if (tmp!=-1 && ch[tmp][o.cnt+1]==0) {
                        q.add(new Point(tmp,o.cnt+1));
                        ch[tmp][o.cnt+1]=1;
                    }
                }
            }
        }
    }

    public static int swap(int num,int i,int j) {
        char[] arr = String.valueOf(num).toCharArray();
        if (i==0 && arr[j]=='0') {
            return -1;
        }
        char tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        BFS();
        System.out.println(answer);
    }
}
