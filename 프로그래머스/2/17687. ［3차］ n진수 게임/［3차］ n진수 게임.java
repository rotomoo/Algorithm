import java.math.BigInteger;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String tmp = "";
        int cnt = 0;
        int findLen = t * m;
        int num = 0;
        while (findLen >= tmp.length()) {
            tmp += new BigInteger(String.valueOf(num++)).toString(n);
        }
        while (cnt != t) {
            answer += tmp.charAt(p-1);
            p += m;
            cnt++;
        }
        return answer.toUpperCase();
    }
}