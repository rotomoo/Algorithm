import java.util.Arrays;

class Solution {
        public static String solution(int[] numbers) {
        String answer = "";
        String[] tmp= new String[numbers.length];
        for (int i=0; i<numbers.length; i++) {
            tmp[i]= String.valueOf(numbers[i]);
        }
        Arrays.sort(tmp,(o1,o2)-> (o2+o1).compareTo(o1+o2));
        if (tmp[0].equals("0")) return "0";
        for (String x : tmp) answer+=x;
        return answer;
    }
}