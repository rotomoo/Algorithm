import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> mlist = new ArrayList<>();
        int ch=0, answer=0;
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp>1) list.add(tmp);
            else if (tmp==0) ch=1;
            else if (tmp==1) answer+=1;
            else mlist.add(tmp);
        }
        Collections.sort(list,Collections.reverseOrder());
        Collections.sort(mlist);
        while (list.size()>0) {
            if (list.size()%2==0) {
                answer+=list.get(0)*list.get(1);
                list.remove(list.get(1));
                list.remove(list.get(0));
            }
            else {
                answer+=list.get(list.size()-1);
                list.remove(list.get(list.size()-1));
            }
        }
        while (mlist.size()>0) {
            if (mlist.size()%2==0) {
                answer+=mlist.get(0)*mlist.get(1);
                mlist.remove(mlist.get(1));
                mlist.remove(mlist.get(0));
            }
            else if (ch==1) {
                mlist.remove(mlist.get(mlist.size()-1));
            }
            else {
                answer+=mlist.get(mlist.size()-1);
                mlist.remove(mlist.get(mlist.size()-1));
            }
        }
        System.out.print(answer);
    }
}
