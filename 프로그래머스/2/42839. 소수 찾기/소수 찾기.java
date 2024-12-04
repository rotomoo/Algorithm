import java.io.IOException;
import java.util.HashSet;

public class Solution {
    static char[] arr;
    static int[] ch;
    static HashSet<Integer> set;

    public static boolean isPossible(int num) {
        if (num<=1) return false;
        for (int i=2; i<num; i++) {
            if (num%i==0) return false;
        }
        return true;
    }

    public static void DFS(int L, int end, String numbers) {
        if (L==end) {
            if (arr[0]=='0') return;
            int num=Integer.parseInt(new String(arr));
            if (isPossible((num))) {
                set.add(num);
            }
        }
        else {
            for (int i=0; i< numbers.length(); i++) {
                if (ch[i]==0) {
                    ch[i]=1;
                    arr[L]=numbers.charAt(i);
                    DFS(L+1,end,numbers);
                    ch[i]=0;
                }
            }
        }
    }

    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        ch = new int[numbers.length()];
        for (int i=1; i<=numbers.length(); i++) {
            arr = new char[i];
            DFS(0,i,numbers);
        }
        answer=set.size();
        return answer;
    }

    public static void main(String[] args) throws IOException {
        String n = "232";
        System.out.println(solution(n));
    }
}