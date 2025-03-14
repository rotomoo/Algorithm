import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr= new int[n+1];
        Arrays.fill(arr,1);
        arr[0]=0;
        for (int i=0; i<lost.length; i++) arr[lost[i]]--;
        for (int i=0; i<reserve.length; i++) arr[reserve[i]]++;
        for (int i=2; i<=n; i++) {
            if(arr[i-1]==0 && arr[i]==2) {
                arr[i]--;
                arr[i-1]++;
            }
            else if (arr[i-1]==2 && arr[i]==0) {
                arr[i]++;
                arr[i-1]--;
            }
        }
        for (int x : arr) if(x!=0) answer++;
        return answer;
    }
}