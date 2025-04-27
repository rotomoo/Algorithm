import java.math.BigInteger;

class Solution {
    public long solution(int w, int h) {
        long answer = (long)w*h-(w+h-BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue());
        return answer;
    }
}