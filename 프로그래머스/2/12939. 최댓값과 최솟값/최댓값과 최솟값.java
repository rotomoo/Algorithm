import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] s1 = s.split(" ");
        Arrays.sort(s1, (o1, o2) ->{
            return Integer.parseInt(o1) - Integer.parseInt(o2);
        });
        answer += s1[0] + " " + s1[s1.length-1];
        return answer;
    }
}