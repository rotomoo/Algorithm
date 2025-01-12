import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        int tmp=Arrays.stream(arr).sum();
        for(int x : numbers) {
            tmp-=x;
        }
        answer=tmp;
        return answer;
    }
}