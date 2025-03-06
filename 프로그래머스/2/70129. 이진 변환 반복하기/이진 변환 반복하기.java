import java.math.BigInteger;

class Solution {
    static int[] answer = {0, 0};

    public static String calc(String s) {
        int len = s.length();
        s = s.replace("0", "");
        answer[1] += len - s.length();
        answer[0]++;
        return new BigInteger(String.valueOf(s.length())).toString(2);
    }

    public static int[] solution(String s) {
        while (true) {
            if (s.equals("1")) break;
            s = calc(s);
        }
        return answer;
    }
}