import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            String str=br.readLine();
            int num=1;
            for (int j=str.length()-1; j>=0; j--) {
                map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+num);
                num*=10;
            }
        }
        ArrayList<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(s1,s2)->map.get(s2)-map.get(s1));
        int answer=0;
        int tmp=9;
        for (char x : list) answer+=tmp--*map.get(x);
        System.out.print(answer);
    }
}
