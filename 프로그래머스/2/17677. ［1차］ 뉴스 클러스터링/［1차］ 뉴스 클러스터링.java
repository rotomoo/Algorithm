import java.util.ArrayList;
import java.util.Collections;

class Solution {

    public static ArrayList<String> slice(String s) {
        ArrayList<String> tmp = new ArrayList<>();
        for (int i = 2; i <= s.length(); i++) {
            String substring = s.substring(i - 2, i).replaceAll("[^A-Z]", "");
            if (substring.length()!=2) continue;
            tmp.add(substring);
        }
        return tmp;
    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        list1 = slice(str1.toUpperCase());
        list2 = slice(str2.toUpperCase());
        Collections.sort(list1);
        Collections.sort(list2);
        int union = 0;
        int intersection = 0;
        String curS = "";
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(curS)) continue;
            curS = list1.get(i);
            if (list2.contains(curS)) {
                union += Math.max(Collections.frequency(list1, curS), Collections.frequency(list2, curS));
                intersection += Math.min(Collections.frequency(list1, curS), Collections.frequency(list2, curS));
            }
            else union+= Collections.frequency(list1, curS);
        }
        curS = "";
        for (int i = 0; i < list2.size(); i++) {
            if (list2.get(i).equals(curS)) continue;
            curS = list2.get(i);
            if (!list1.contains(curS)) union+= Collections.frequency(list2, curS);
        }
        if (union==0) answer = 65536;
        else answer = (int)((double)intersection / (double)union * 65536);
        return answer;
    }
}