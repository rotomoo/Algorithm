import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(String s) {
        String[] split = s.split("},\\{");
        ArrayList<String> list = new ArrayList<>();
        for (String x : split) {
            x = x.replaceAll("[{}]", "");
            list.add(x);
        }
        Collections.sort(list, (o1, o2) -> o1.length()-o2.length());
        ArrayList<Integer> answer = new ArrayList<>();
        for (String x : list) {
            String[] split2 = x.split(",");
            for (String st : split2) {
                int tmp = Integer.parseInt(st);
                if (!answer.contains(tmp)) answer.add(tmp);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}