import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt = 0;
        int rt = w-1;
        int lt_high = arr[lt];
        int rt_high = arr[rt];
        int answer = 0;
        while (lt < rt) {
            if (lt_high <= rt_high) {
                lt++;
                lt_high = Math.max(lt_high, arr[lt]);
                answer += lt_high - arr[lt];
            }
            else {
                rt --;
                rt_high = Math.max(rt_high, arr[rt]);
                answer += rt_high - arr[rt];
            }
        }
        System.out.println(answer);
    }
}
