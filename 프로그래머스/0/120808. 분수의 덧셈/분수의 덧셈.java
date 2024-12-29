class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int lcm = LCM(denom1, denom2);
        int quotient1 = lcm / denom1;
        int quotient2 = lcm / denom2;
        answer[0] = numer1 * quotient1 + numer2 * quotient2;
        answer[1] = lcm;
        int gcd = GCD(answer[0], answer[1]);
        if (gcd != 1) {
            answer[0] /= gcd;
            answer[1] /= gcd;
        }
        return answer;
    }
    
    public static int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }

    public static int LCM(int a, int b) {
        return a*b / GCD(a,b);
    }
}