import java.math.BigInteger;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i=1; i<arr.length; i++) {
            int x=BigInteger.valueOf(answer).gcd(BigInteger.valueOf(arr[i])).intValue();
            answer*=arr[i]/x;
        }
        return answer;
    }
}